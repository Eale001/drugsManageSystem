package com.eale.drugs.controller.drugs;


import com.eale.drugs.bean.DrugSupplier;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class DrugSupplierController {

    @Autowired
    private DrugSupplierService drugSupplierService;


    /**
     * 根据Id查询
     * @param supplierId
     * @return
     */
    @RequestMapping(value = "findDrugSupplierById",method = RequestMethod.GET)
    public ResultVO findById(@PathVariable(value = "supplierId")Long supplierId){
        DrugSupplier drugSupplier = drugSupplierService.findById(supplierId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugSupplier);
    }


    /**
     * 添加
     * @param drugSupplier
     * @return
     */
    @RequestMapping(value ="saveDrugSupplier" ,method = RequestMethod.POST)
    public ResultVO save(DrugSupplier drugSupplier){
        if (null == drugSupplier){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugSupplierService.save(drugSupplier);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param supplierId
     * @return
     */
    @RequestMapping(value = "deleteDrugSupplierById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "supplierId")Long supplierId) {
        drugSupplierService.deleteById(supplierId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "findDrugSupplierAll",method = RequestMethod.GET)
    public ResultVO findAll() {
        List<DrugSupplier> drugsList= drugSupplierService.findAll();
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugsList);
    }


    /**
     * 修改
     * @param supplierId
     * @param drugSupplier
     * @return
     */
    @RequestMapping(value = "updateDrugSupplier",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "supplierId")Long supplierId, DrugSupplier drugSupplier) {
        DrugSupplier drugSupplier1 = drugSupplierService.findById(supplierId);
        if (null == drugSupplier1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        DrugSupplier drugSupplier2 = drugSupplierService.update(drugSupplier);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugSupplier2);
    }

}
