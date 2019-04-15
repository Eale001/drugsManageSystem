package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.DrugInventoryInfo;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugInventoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 库存
 */
@Controller
@RequestMapping("/")
public class DrugInventoryInfoController {

    @Autowired
    private DrugInventoryInfoService drugInventoryInfoService;

    /**根据Id查询
     *
     * @param inventoryinfoId
     * @return
     */
    @RequestMapping(value = "findDrugInventoryInfoById",method = RequestMethod.GET)
    public ResultVO findById(@PathVariable(value = "inventoryinfoId")Long inventoryinfoId){
        DrugInventoryInfo drugInventoryInfo = drugInventoryInfoService.findById(inventoryinfoId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",inventoryinfoId);
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

    /**
     * 查询全部
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findDrugInventoryInfoAll",method = RequestMethod.GET)
    public ResultVO findAll() {
        List<DrugInventoryInfo> drugInventoryInfoList= drugInventoryInfoService.findAll();
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugInventoryInfoList);
    }


    /**
     * 修改
     * @param inventoryinfoId
     * @param drugInventoryInfo
     * @return
     */
    @RequestMapping(value = "updateDrugInventoryInfo",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "inventoryinfoId")Long inventoryinfoId, DrugInventoryInfo drugInventoryInfo) {
        DrugInventoryInfo drugInventoryInfo1 = drugInventoryInfoService.findById(inventoryinfoId);
        if (null == drugInventoryInfo1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        DrugInventoryInfo drugInventoryInfo2 = drugInventoryInfoService.update(drugInventoryInfo);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugInventoryInfo2);
    }

}
