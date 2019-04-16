package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.DrugInventoryInfo;
import com.eale.drugs.bean.Drugs;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.DrgusVO;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
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

import java.util.ArrayList;
import java.util.List;

/**
 * 库存
 */
@Controller
@RequestMapping("/")
public class DrugInventoryInfoController {

    @Autowired
    private DrugInventoryInfoService drugInventoryInfoService;

    @Autowired
    private DrugsService drugsService;

    @Autowired
    private UserService userService;

    /**
     * 进入 库存列表
     * @param model
     * @return
     */
    @RequestMapping(value = "findDrugInventoryInfoAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugInventoryInfo> drugInventoryInfoList= drugInventoryInfoService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (DrugInventoryInfo drugInventoryInfo : drugInventoryInfoList) {
            DrgusVO drgusVO = new DrgusVO();
            Drugs drugs = drugsService.findById(drugInventoryInfo.getDrugsId());
            drgusVO.setDrugs(drugs);
            drgusVO.setDrugInventoryInfo(drugInventoryInfo);
            User user =userService.findById(drugInventoryInfo.getCreateUserid());
            drgusVO.setUserName(user.getUserName());
            drgusVOSList.add(drgusVO);
        }

        model.addAttribute("drgusVOSList",drgusVOSList);

        return "drugs/drugsInventoryInfoManage";
    }

    /**
     * 查询 详情
     *
     * @param inventoryinfoId
     * @return
     */
    @RequestMapping(value = "goDrugsInventoryInfoDetail",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "inventoryinfoId")Long inventoryinfoId,Model model){
        DrugInventoryInfo drugInventoryInfo = drugInventoryInfoService.findById(inventoryinfoId);
        DrgusVO drgusVO = new DrgusVO();
        Drugs drugs = drugsService.findById(drugInventoryInfo.getDrugsId());
        drgusVO.setDrugs(drugs);
        drgusVO.setDrugInventoryInfo(drugInventoryInfo);
        User user =userService.findById(drugInventoryInfo.getCreateUserid());
        drgusVO.setUserName(user.getUserName());
        model.addAttribute("inventoryinfo",drgusVO);
        return "drugs/drugsInventoryInfoDetail";
    }

    /**
     * 添加
     * @param drugInventoryInfo
     * @return
     */
    @RequestMapping(value ="saveDrugInventoryInfo" ,method = RequestMethod.POST)
    public ResultVO saveById(DrugInventoryInfo drugInventoryInfo){
        if (null == drugInventoryInfo){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugInventoryInfoService.saveById(drugInventoryInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param inventoryinfoId
     * @return
     */
    @RequestMapping(value = "deleteDrugInventoryInfoById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "inventoryinfoId")Long inventoryinfoId) {
        drugInventoryInfoService.deleteById(inventoryinfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }


}
