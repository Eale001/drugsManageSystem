package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.Drugs;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 药品信息controller
 */
@Controller
@RequestMapping("/")
public class DrugsController {

    @Autowired
    private DrugsService drugsService;


    /**
     * 根据Id查询
     * @param drugsId
     * @return
     */
    @RequestMapping(value = "findDrugsById",method = RequestMethod.GET)
    public ResultVO findById(@PathVariable(value = "drugsId")Long drugsId){
        Drugs drugs = drugsService.findById(drugsId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugs);
    }


    /**
     * 添加
     * @param drugs
     * @return
     */
    @RequestMapping(value ="saveDrugs" ,method = RequestMethod.POST)
    public ResultVO saveById(Drugs drugs){
        if (null == drugs){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        drugsService.saveById(drugs);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 删除
     * @param drugsId
     * @return
     */
    @RequestMapping(value = "deleteDrugsById",method = RequestMethod.GET)
    public ResultVO deleteById(@PathVariable(value = "drugsId")Long drugsId) {
        drugsService.deleteById(drugsId);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"删除成功");
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "findDrgusAll",method = RequestMethod.GET)
    public ResultVO findAll() {
        List<Drugs> drugsList= drugsService.findAll();
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"查询成功",drugsList);
    }


    /**
     * 修改
     * @param drugsId
     * @param drugs
     * @return
     */
    @RequestMapping(value = "updateDrugs",method = RequestMethod.POST)
    public ResultVO update(@PathVariable(value = "drugsId")Long drugsId, Drugs drugs) {
        Drugs drugs1 = drugsService.findById(drugsId);
        if (null == drugs1){
            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
        }
        Drugs drugs2 = drugsService.update(drugs);
        return new ResultVO(ResultEnum.SUCCESS.getCode(),"修改成功",drugs2);
    }


}
