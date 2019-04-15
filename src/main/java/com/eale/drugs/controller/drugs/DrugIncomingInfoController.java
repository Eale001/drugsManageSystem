package com.eale.drugs.controller.drugs;


import com.eale.drugs.bean.DrugIncomingInfo;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugIncomingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**根据Id查询
     *
     * @param incominginfoId
     * @return
     */
    @RequestMapping(value = "findDrugIncomingInfoById",method = RequestMethod.GET)
    public ResultVO findById(@PathVariable(value = "incominginfoId")Long incominginfoId){
        DrugIncomingInfo drugIncomingInfo =  drugIncomingInfoService.findById(incominginfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugIncomingInfo);
    }

    /**
     * 添加
     * @param drugIncomingInfo
     * @return
     */
    @RequestMapping(value ="saveDrugIncomingInfo" ,method = RequestMethod.POST)
    public ResultVO saveById(DrugIncomingInfo drugIncomingInfo){
        if (null == drugIncomingInfo){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugIncomingInfoService.saveById(drugIncomingInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param incominginfoId
     * @return
     */
    @RequestMapping(value = "deleteDrugIncomingInfoById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "incominginfoId")Long incominginfoId) {
        drugIncomingInfoService.deleteById(incominginfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }

    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findDrugIncomingInfoAll",method = RequestMethod.GET)
    public ResultVO findAll() {
        List<DrugIncomingInfo> drugIncomingInfoList= drugIncomingInfoService.findAll();
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugIncomingInfoList);
    }


    /**
     * 修改
     * @param incominginfoId
     * @param drugIncomingInfo
     * @return
     */
    @RequestMapping(value = "updateDrugIncomingInfo",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "incominginfoId")Long incominginfoId, DrugIncomingInfo drugIncomingInfo) {
        DrugIncomingInfo drugIncomingInfo1=  drugIncomingInfoService.findById(incominginfoId);
        if (null == drugIncomingInfo1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        DrugIncomingInfo drugIncomingInfo2 = drugIncomingInfoService.update(drugIncomingInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugIncomingInfo2);
    }


}
