package com.eale.drugs.controller.drugs;


import com.eale.drugs.bean.*;
import com.eale.drugs.common.DrgusVO;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 销售
 */
@Controller
@RequestMapping("/")
public class DrugSaleInfoController {

    @Autowired
    private DrugSaleInfoService drugSaleInfoService;

    @Autowired
    private DrugDeliveryInfoService drugDeliveryInfoService;

    @Autowired
    private DrugInventoryInfoService drugInventoryInfoService;

    @Autowired
    private DrugsService drugsService;

    @Autowired
    private UserService userService;


    /**
     * 进入到 销售 列表
     * @return
     */
    @RequestMapping(value = "findDrugSaleInfoAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugSaleInfo> drugSaleInfoList= drugSaleInfoService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (DrugSaleInfo drugSaleInfo : drugSaleInfoList) {
            DrgusVO drgusVO= new DrgusVO();
            Drugs drugs = drugsService.findById(drugSaleInfo.getDrugsId());
            drgusVO.setDrugs(drugs);
            drgusVO.setDrugSaleInfo(drugSaleInfo);
            User user =userService.findById(drugSaleInfo.getSaleUserid());
            drgusVO.setUserName(user.getUserName());
            drgusVOSList.add(drgusVO);
        }
        model.addAttribute("drgusVOSList",drgusVOSList);
        return "drugs/drugsSaleInfoManage";
    }


    /**
     * 进入到 增加，修改 页面
     * @param saleinfoId
     * @return
     */
    @RequestMapping(value = "findDrugSaleInfoById",method = RequestMethod.GET)
    public String findById(@RequestParam(value = "saleinfoId",required = false)Long saleinfoId, HttpSession session, Model model){
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        if (null!=saleinfoId){
            DrugSaleInfo drugSaleInfo = drugSaleInfoService.findById(saleinfoId);
            Drugs drugs = drugsService.findById(drugSaleInfo.getDrugsId());
            DrgusVO drgusVO =new DrgusVO();
            drgusVO.setDrugs(drugs);
            drgusVO.setDrugSaleInfo(drugSaleInfo);
            model.addAttribute("drugSaleInfo",drgusVO);
        }
        List<Drugs> drugsList = drugsService.findAll();
        model.addAttribute("drugsList",drugsList);
        return "drugs/drugsSaleInfoEdit";
    }


    /**
     *  新增，修改 保存
     * @param drugSaleInfo
     * @return
     */
    @RequestMapping(value ="saveDrugSaleInfo" ,method = RequestMethod.POST)
    public String saveById(DrugSaleInfo drugSaleInfo,HttpSession session,Model model){
        System.out.println(drugSaleInfo);
        Long userId=(Long) session.getAttribute("userId");
        drugSaleInfo.setSaleUserid(userId);
        Timestamp time=new Timestamp(System.currentTimeMillis());
        drugSaleInfo.setSaleDate(time);

        //库存操作
        DrugInventoryInfo inventoryInfo = drugInventoryInfoService.findByDrugsId(drugSaleInfo.getDrugsId());
        if (null==inventoryInfo){
            model.addAttribute("errorsmess","药品库存不足");
            return "/findDrugSaleInfoById";
        }
        long number = inventoryInfo.getInventoryinfoNumber() - drugSaleInfo.getSaleinfoNumber();
        if (number<0){
            model.addAttribute("errorsmess","药品库存不足");
            return "/findDrugSaleInfoById";
        }
        inventoryInfo.setInventoryinfoNumber(number);
        drugInventoryInfoService.saveById(inventoryInfo);

        //出库操作
        DrugDeliveryInfo drugDeliveryInfo = new DrugDeliveryInfo();
        drugDeliveryInfo.setDrugsId(drugSaleInfo.getDrugsId());
        drugDeliveryInfo.setDeliveryinfoNumber(drugSaleInfo.getSaleinfoNumber());
        drugDeliveryInfo.setDeliveryinfoPrice(drugSaleInfo.getSaleinfoPrice());
        drugDeliveryInfo.setCreateUserid(userId);
        drugDeliveryInfo.setCreateDate(time);
        drugDeliveryInfoService.saveById(drugDeliveryInfo);

        //上述完成才能保存销售记录
        drugSaleInfoService.saveById(drugSaleInfo);

        /**
         * 没有加事务
         */
//        if (null == drugSaleInfo){
//            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
//        }
        return "/findDrugSaleInfoAll";
    }

    /**
     * 删除
     * @param saleinfoId
     * @return
     */
    @RequestMapping(value = "deleteDrugSaleInfoById",method = RequestMethod.GET)
    public String deleteById(@RequestParam(value = "saleinfoId")Long saleinfoId,Model model) {
        drugSaleInfoService.deleteById(saleinfoId);
        model.addAttribute("seccuss","操作成功");
        return "/findDrugSaleInfoAll";
    }



    /**
     * 查看详情
     * @param saleinfoId
     * @param model
     * @return
     */
    @RequestMapping(value = "goDrugSaleInfoDetail",method = RequestMethod.GET)
    public String update(@RequestParam(value = "saleinfoId")Long saleinfoId,HttpSession session,Model model) {
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);

        DrugSaleInfo drugSaleInfo = drugSaleInfoService.findById(saleinfoId);
        Drugs drugs = drugsService.findById(drugSaleInfo.getDrugsId());
        DrgusVO drgusVO =new DrgusVO();
        drgusVO.setDrugs(drugs);
        drgusVO.setDrugSaleInfo(drugSaleInfo);
        model.addAttribute("drugSaleInfo",drgusVO);

        return "drugs/drugsSaleInfoDetail";
    }

}
