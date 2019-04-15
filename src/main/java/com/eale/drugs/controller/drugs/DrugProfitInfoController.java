package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.DrugProfitInfo;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugProfitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 利润
 */
@Controller
@RequestMapping("/")
public class DrugProfitInfoController {

    @Autowired
    private DrugProfitInfoService drugProfitInfoService;


    /**
     * 根据Id查询
     * @param profitinfoId
     * @return
     */
    @RequestMapping(value = "findDrugProfitInfoById",method = RequestMethod.GET)
    public ResultVO findById(@PathVariable(value = "profitinfoId")Long profitinfoId){
        DrugProfitInfo drugProfitInfo = drugProfitInfoService.findById(profitinfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugProfitInfo);
    }


    /**
     * 添加
     * @param drugProfitInfo
     * @return
     */
    @RequestMapping(value ="saveDrugProfitInfo" ,method = RequestMethod.POST)
    public ResultVO saveById(DrugProfitInfo drugProfitInfo){
        if (null == drugProfitInfo){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugProfitInfoService.saveById(drugProfitInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param profitinfoId
     * @return
     */
    @RequestMapping(value = "deleteDrugProfitInfoById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "profitinfoId")Long profitinfoId) {
        drugProfitInfoService.deleteById(profitinfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "findDrugProfitInfoAll",method = RequestMethod.GET)
    public ResultVO findAll() {
        List<DrugProfitInfo> drugProfitInfoList= drugProfitInfoService.findAll();
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugProfitInfoList);
    }


    /**
     * 修改
     * @param profitinfoId
     * @param drugProfitInfo
     * @return
     */
    @RequestMapping(value = "updateDrugProfitInfo",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "profitinfoId")Long profitinfoId, DrugProfitInfo drugProfitInfo) {
        DrugProfitInfo drugProfitInfo1 = drugProfitInfoService.findById(profitinfoId);
        if (null == drugProfitInfo1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        DrugProfitInfo drugProfitInfo2 = drugProfitInfoService.update(drugProfitInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugProfitInfo2);
    }

}
