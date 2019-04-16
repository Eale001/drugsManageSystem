package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.DrugDeliveryInfo;
import com.eale.drugs.bean.DrugInventoryInfo;
import com.eale.drugs.bean.Drugs;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.DrgusVO;
import com.eale.drugs.service.DrugDeliveryInfoService;
import com.eale.drugs.service.DrugInventoryInfoService;
import com.eale.drugs.service.DrugsService;
import com.eale.drugs.service.UserService;
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
 * 出库信息controller
 */
@Controller
@RequestMapping("/")
public class DrugDeliveryInfoController {

    @Autowired
    private DrugDeliveryInfoService drugDeliveryInfoService;

    @Autowired
    private DrugInventoryInfoService drugInventoryInfoService;
    
    @Autowired
    private DrugsService drugsService;

    @Autowired
    private UserService userService;


    /**
     * 进入出库管理列表
     * @return
     */
    @RequestMapping(value = "findDrugDeliveryInfoAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugDeliveryInfo> drugDeliveryInfoList= drugDeliveryInfoService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (DrugDeliveryInfo drugDeliveryInfo: drugDeliveryInfoList) {
            DrgusVO drgusVO= new DrgusVO();
            Drugs drugs = drugsService.findById(drugDeliveryInfo.getDrugsId());
            drgusVO.setDrugs(drugs);
            drgusVO.setData(drugDeliveryInfo);
            User user =userService.findById(drugDeliveryInfo.getCreateUserid());
            drgusVO.setUserName(user.getUserName());
            drgusVOSList.add(drgusVO);
        }
        model.addAttribute("drugDeliveryInfoList",drgusVOSList);
        return "drugs/drugsDeliveryInfoManage";
    }


    /**
     * 进入 新增 修改页面
     * @param deliveryinfoId
     * @return
     */
    @RequestMapping(value = "findDrugDeliveryInfoById",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "deliveryinfoId")Long deliveryinfoId,Model model,HttpSession session){
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        if (deliveryinfoId!=null){
            DrugDeliveryInfo drugDeliveryInfo = drugDeliveryInfoService.findById(deliveryinfoId);
            Drugs drugs = drugsService.findById(drugDeliveryInfo.getDrugsId());
            DrgusVO drgusVO =new DrgusVO();
            drgusVO.setDrugs(drugs);
            drgusVO.setData(drugDeliveryInfo);
            model.addAttribute("drugs",drgusVO);
        }
        List<Drugs> drugsList = drugsService.findAll();
        model.addAttribute("drugsList",drugsList);
        return "drugs/drugsDeliveryInfoEdit";
    }


    /**
     * 新增 修改 保存
     * @param drugDeliveryInfo
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value ="saveDrugDeliveryInfo" ,method = RequestMethod.POST)
    public String save(DrugDeliveryInfo drugDeliveryInfo, Model model, HttpSession session){

        System.out.println(drugDeliveryInfo);
        Long userId=(Long) session.getAttribute("userId");
        drugDeliveryInfo.setCreateUserid(userId);
        Timestamp time=new Timestamp(System.currentTimeMillis());
        drugDeliveryInfo.setCreateDate(time);

        DrugInventoryInfo drugInventoryInfo = drugInventoryInfoService.findByDrugsId(drugDeliveryInfo.getDrugsId());
        if (null == drugInventoryInfo){
            model.addAttribute("errorsmess","药品库存不足");
            return "drugs/drugsDeliveryInfoEdit";
        }

        long number=drugInventoryInfo.getInventoryinfoNumber()-drugDeliveryInfo.getDeliveryinfoNumber();
        drugInventoryInfo.setInventoryinfoNumber(number);
        drugInventoryInfoService.saveById(drugInventoryInfo);
        drugDeliveryInfoService.saveById(drugDeliveryInfo);


//        DrugDeliveryInfo byId = drugDeliveryInfoService.findById(drugDeliveryInfo.getDeliveryinfoId());
//        if (null == byId){
//            model.addAttribute("errormess","操作失败");
//            return "drugs/drugDeliveryInfoEdit";
//        }
        model.addAttribute("seccess","操作成功");
        return "/findDrugDeliveryInfoAll";
    }

    /**
     * 删除
     * @param drugsId
     * @return
     */
    @RequestMapping(value = "deleteDrugDeliveryInfoById",method = RequestMethod.GET)
    public String deleteById(@PathVariable(value = "drugsId")Long drugsId,Model model) {
        drugDeliveryInfoService.deleteById(drugsId);
        model.addAttribute("success","操作成功");
        return "/findDrugDeliveryInfoAll";
    }


    /**
     * 查询 ，根据ID查询
     * @param deliveryinfoId
     * @return
     */
    @RequestMapping(value = "goDrugDeliveryInfoDetail",method = RequestMethod.GET)
    public String update(@PathVariable(value = "deliveryinfoId")Long deliveryinfoId,HttpSession session,Model model) {
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        DrugDeliveryInfo drugDeliveryInfo = drugDeliveryInfoService.findById(deliveryinfoId);
        Drugs drugs = drugsService.findById(drugDeliveryInfo.getDrugsId());
        DrgusVO drgusVO =new DrgusVO();
        drgusVO.setDrugs(drugs);
        drgusVO.setData(drugDeliveryInfo);
        model.addAttribute("drugs",drgusVO);
        return "drugs/drugsDeliveryInfoDetail";
    }

}
