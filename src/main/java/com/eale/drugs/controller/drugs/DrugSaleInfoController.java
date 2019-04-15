package com.eale.drugs.controller.drugs;


import com.eale.drugs.bean.DrugSaleInfo;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugSaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 销售
 */
@Controller
@RequestMapping("/")
public class DrugSaleInfoController {

    @Autowired
    private DrugSaleInfoService drugSaleInfoService;


    /**
     * 根据Id查询
     * @param saleinfoId
     * @return
     */
    @RequestMapping(value = "findDrugSaleInfoById",method = RequestMethod.GET)
    public ResultVO findById(@PathVariable(value = "saleinfoId")Long saleinfoId){
        DrugSaleInfo drugSaleInfo = drugSaleInfoService.findById(saleinfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugSaleInfo);
    }


    /**
     * 添加
     * @param drugSaleInfo
     * @return
     */
    @RequestMapping(value ="saveDrugSaleInfo" ,method = RequestMethod.POST)
    public ResultVO saveById(DrugSaleInfo drugSaleInfo){
        if (null == drugSaleInfo){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugSaleInfoService.saveById(drugSaleInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param saleinfoId
     * @return
     */
    @RequestMapping(value = "deleteDrugSaleInfoById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "saleinfoId")Long saleinfoId) {
        drugSaleInfoService.deleteById(saleinfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "findDrugSaleInfoAll",method = RequestMethod.GET)
    public ResultVO findAll() {
        List<DrugSaleInfo> drugSaleInfoList= drugSaleInfoService.findAll();
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugSaleInfoList);
    }


    /**
     * 修改
     * @param saleinfoId
     * @param drugSaleInfo
     * @return
     */
    @RequestMapping(value = "updateDrugSaleInfo",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "saleinfoId")Long saleinfoId, DrugSaleInfo drugSaleInfo) {
        DrugSaleInfo drugSaleInfo1 = drugSaleInfoService.findById(saleinfoId);
        if (null == drugSaleInfo1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        DrugSaleInfo drugSaleInfo2 = drugSaleInfoService.update(drugSaleInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugSaleInfo2);
    }

}
