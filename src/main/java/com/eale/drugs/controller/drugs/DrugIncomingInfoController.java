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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 入库操作
 */
@Controller
@RequestMapping("/")
public class DrugIncomingInfoController {

    @Autowired
    private DrugIncomingInfoService drugIncomingInfoService;

    @Autowired
    private DrugInventoryInfoService drugInventoryInfoService;

    @Autowired
    private DrugsService drugsService;

    @Autowired
    private UserService userService;

    @Autowired
    private DrugSupplierService drugSupplierService;

    /**
     * 进入 入库管理列表
     * @return
     */
    @RequestMapping(value = "findDrugIncomingInfoAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugIncomingInfo> drugIncomingInfoList= drugIncomingInfoService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (DrugIncomingInfo drugIncomingInfo : drugIncomingInfoList) {
            DrgusVO drgusVO = new DrgusVO();
            Drugs drugs = drugsService.findById(drugIncomingInfo.getDrugsId());
            drgusVO.setDrugs(drugs);
            drgusVO.setDrugIncomingInfo(drugIncomingInfo);
            User user =userService.findById(drugIncomingInfo.getCreateUserid());
            drgusVO.setUserName(user.getUserName());
            DrugSupplier drugSupplier= drugSupplierService.findById(drugIncomingInfo.getSupplierId());
            drgusVO.setDrugSupplier(drugSupplier);
            drgusVOSList.add(drgusVO);
        }

        model.addAttribute("drgusVOSList",drgusVOSList);

        return "drugs/drugsIncomingInfoManage";
    }



    /**
     * 进入 增加，修改 页面
     *
     * @param incominginfoId
     * @return
     */
    @RequestMapping(value = "findDrugIncomingInfoById",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "incominginfoId")Long incominginfoId,Model model, HttpSession session){
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        if (incominginfoId != null){
            DrugIncomingInfo drugIncomingInfo =  drugIncomingInfoService.findById(incominginfoId);
            Drugs drugs = drugsService.findById(drugIncomingInfo.getDrugsId());
            DrgusVO drgusVO =new DrgusVO();
            drgusVO.setDrugs(drugs);
            drgusVO.setDrugIncomingInfo(drugIncomingInfo);
            model.addAttribute("drugIncoming",drgusVO);
        }
        List<Drugs> drugsList = drugsService.findAll();
        model.addAttribute("drugsList",drugsList);
        List<DrugSupplier> supplierList = drugSupplierService.findAll();
        model.addAttribute("supplierList",supplierList);
        return "drugs/drugsIncomingInfoEdit";
    }

    /**
     * 增加，修改  保存
     * @param drugIncomingInfo
     * @return
     */
    @RequestMapping(value ="saveDrugIncomingInfo" ,method = RequestMethod.POST)
    public String saveById(DrugIncomingInfo drugIncomingInfo,HttpSession session,Model model){
        System.out.println(drugIncomingInfo);
        Long userId=(Long) session.getAttribute("userId");
        drugIncomingInfo.setCreateUserid(userId);
        Timestamp time=new Timestamp(System.currentTimeMillis());
        drugIncomingInfo.setCreateDate(time);
        drugIncomingInfoService.saveById(drugIncomingInfo);

        DrugInventoryInfo inventoryInfo = drugInventoryInfoService.findByDrugsId(drugIncomingInfo.getDrugsId());
        if (null==inventoryInfo){
            DrugInventoryInfo drugInventoryInfo=new DrugInventoryInfo();
            drugInventoryInfo.setDrugsId(drugIncomingInfo.getDrugsId());
            drugInventoryInfo.setInventoryinfoNumber(drugIncomingInfo.getIncominginfoNumber());
            drugInventoryInfo.setCreateDate(time);
            drugInventoryInfo.setCreateUserid(userId);
            drugInventoryInfoService.saveById(drugInventoryInfo);
        }

        long number = inventoryInfo.getInventoryinfoNumber() + drugIncomingInfo.getIncominginfoNumber();
        inventoryInfo.setInventoryinfoNumber(number);
        drugInventoryInfoService.saveById(inventoryInfo);

//        drugIncomingInfoService.findById(drugIncomingInfo.)
//
//        if (null == drugIncomingInfo){
//            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
//        }
        model.addAttribute("success","操作成功");
        return "/findDrugIncomingInfoById";
    }

    /**
     * 删除
     * @param incominginfoId
     * @return
     */
    @RequestMapping(value = "deleteDrugIncomingInfoById",method = RequestMethod.GET)
    public String deleteById(@PathVariable(value = "incominginfoId")Long incominginfoId,Model model) {
        drugIncomingInfoService.deleteById(incominginfoId);
        model.addAttribute("success","操作成功");
        return "/findDrugIncomingInfoById";
    }


    /**
     * 查询详情
     * @param incominginfoId
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "goDrugsIncomingInfoDetail",method = RequestMethod.GET)
    public String  update(@PathVariable(value = "incominginfoId")Long incominginfoId,HttpSession session,Model model) {
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        DrugIncomingInfo drugIncomingInfo=  drugIncomingInfoService.findById(incominginfoId);
        Drugs drugs = drugsService.findById(drugIncomingInfo.getDrugsId());
        DrgusVO drgusVO =new DrgusVO();
        drgusVO.setDrugs(drugs);
        drgusVO.setDrugIncomingInfo(drugIncomingInfo);
        DrugSupplier drugSupplier= drugSupplierService.findById(drugIncomingInfo.getSupplierId());
        drgusVO.setDrugSupplier(drugSupplier);
        model.addAttribute("drugIncoming",drgusVO);
        return "drugs/drugsIncomingInfoDetail";
    }


}
