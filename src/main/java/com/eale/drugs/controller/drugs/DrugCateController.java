package com.eale.drugs.controller.drugs;


import com.eale.drugs.bean.DrugCate;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugCateService;
import com.eale.drugs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * 药物类别Controller
 */
@Controller
@RequestMapping("/")
public class DrugCateController {

    @Autowired
    private DrugCateService drugCateService;

    @Autowired
    private UserService userService;

    /**
     * 进入管理界面
     * @return
     */
    @RequestMapping(value = "findDrugCateAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugCate> drugCateList= drugCateService.findAll();
        model.addAttribute("drugCateList",drugCateList);
        return "drugs/drugsCateManage";
    }


    /**
     * 进入 新增  修改
     * @param cateId
     * @param model
     * @return
     */
    @RequestMapping(value = "findDrugCateById",method = RequestMethod.GET)
    public String findById(@RequestParam(value = "cateId",required = false)Long cateId, Model model, HttpSession session){
        if(cateId!=null){
            DrugCate drugcate = drugCateService.findById(cateId);
            Long userId=(Long)session.getAttribute("userId");
            User user = userService.findById(userId);
            model.addAttribute("drugscate",drugcate);
            model.addAttribute("user",user);
        }
        return "drugs/drugsCateEdit";
    }

    /**
     *  新增 修改  保存
     * @param drugCate
     * @return
     */
    @RequestMapping(value ="saveDrugCate" ,method = RequestMethod.POST)
    public String save(DrugCate drugCate, Model model, HttpSession session){

        System.out.println(drugCate);
        Long userId =(Long) session.getAttribute("userId");
        drugCate.setCreateUserid(userId);
        Timestamp time=new Timestamp(System.currentTimeMillis());
        drugCate.setCreateDate(time);
        drugCateService.saveById(drugCate);
//        DrugCate cate = drugCateService.findById(drugCate.getCateId());

//        if (null != cate){
        model.addAttribute("success","操作成功");
        return "/findDrugCateAll";
//        }
//        model.addAttribute("errormes","操作失败");
//        return "drugs/drugsCateEdit";
    }

    /**
     * 删除
     * @param cateId
     * @return
     */
    @RequestMapping(value = "deleteDrugCateById",method = RequestMethod.GET)
    public String deleteById(@RequestParam(value = "cateId")Long cateId,Model model) {
        drugCateService.deleteById(cateId);
        model.addAttribute("success","操作成功");
        return "/findDrugCateAll";
    }

    /**
     * 查询
     * @param cateId
     * @param model
     * @return
     */
    @RequestMapping(value = "goDrugCateDetail",method = RequestMethod.GET)
    public String goDetail(Long cateId,Model model,HttpSession session){
        Long userId=(Long)session.getAttribute("userId");
        User user = userService.findById(userId);
        DrugCate drugCate = drugCateService.findById(cateId);
        model.addAttribute("user",user);
        model.addAttribute("cate",drugCate);
        return "drugs/drugsCateDetail";
    }


 }
