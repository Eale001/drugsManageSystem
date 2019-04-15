package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.DrugDeliveryInfo;
import com.eale.drugs.bean.Drugs;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
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
    @ResponseBody
    @RequestMapping(value = "findDrugDeliveryInfoAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugDeliveryInfo> drugDeliveryInfoList= drugDeliveryInfoService.findAll();
        model.addAttribute("drugDeliveryInfoList",drugDeliveryInfoList);
        return "drugs/drugDeliveryInfoManage";
    }


    /**
     * 进入 新增 修改页面
     * @param deliveryinfoId
     * @return
     */
    @RequestMapping(value = "findDrugDeliveryInfoById",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "deliveryinfoId")Long deliveryinfoId,Model model){
        if (deliveryinfoId!=null){
            DrugDeliveryInfo drugDeliveryInfo = drugDeliveryInfoService.findById(deliveryinfoId);
            Drugs drugs = drugsService.findById(drugDeliveryInfo.getDrugsId());
            model.addAttribute("drugDeliveryInfo",drugDeliveryInfo);
            model.addAttribute("drugs",drugs);
        }
        List<DrugDeliveryInfo> drugDeliveryInfoList = drugDeliveryInfoService.findAll();
        model.addAttribute("drugDeliveryInfoList",drugDeliveryInfoList);
        return "drugs/drugDeliveryInfoEdit";
    }


    /**
     * 新增 修改 保存
     * @param drugDeliveryInfo
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value ="saveDrugDeliveryInfo" ,method = RequestMethod.POST)
    public ResultVO save(DrugDeliveryInfo drugDeliveryInfo, Model model, HttpSession session){

        System.out.println(drugDeliveryInfo);
        Long userId=(Long) session.getAttribute("userId");



        if (null == drugDeliveryInfo){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugDeliveryInfoService.saveById(drugDeliveryInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param drugsId
     * @return
     */
    @RequestMapping(value = "deleteDrugDeliveryInfoById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "drugsId")Long drugsId) {
        drugDeliveryInfoService.deleteById(drugsId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }




    /**
     * 修改
     * @param deliveryinfoId
     * @param drugDeliveryInfo
     * @return
     */
    @RequestMapping(value = "updateDrugDeliveryInfo",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "deliveryinfoId")Long deliveryinfoId, DrugDeliveryInfo drugDeliveryInfo) {
        DrugDeliveryInfo drugDeliveryInfo1 = drugDeliveryInfoService.findById(deliveryinfoId);
        if (null == drugDeliveryInfo1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        DrugDeliveryInfo drugDeliveryInfo2 = drugDeliveryInfoService.update(drugDeliveryInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugDeliveryInfo2);
    }

}
