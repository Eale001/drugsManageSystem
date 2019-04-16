package com.eale.drugs.controller.drugs;


import com.eale.drugs.bean.DrugSupplier;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.DrgusVO;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugSupplierService;
import com.eale.drugs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DrugSupplierController {

    @Autowired
    private DrugSupplierService drugSupplierService;

    @Autowired
    private UserService userService;

    /**
     * 进入到 供应商 列表
     * @return
     */
    @RequestMapping(value = "findDrugSupplierAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DrugSupplier> drugsList= drugSupplierService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (DrugSupplier drugSupplier : drugsList ) {
            DrgusVO drgusVO = new DrgusVO();
            User user =userService.findById(drugSupplier.getCreateUserid());
            drgusVO.setDrugSupplier(drugSupplier);
            drgusVO.setUserName(user.getUserName());
            drgusVOSList.add(drgusVO);
        }
        model.addAttribute("drgusVOSList",drgusVOSList);
        return "drugs/drugsSupplierManage";
    }


    /**
     * 进入 新增,修改 页面
     * @param supplierId
     * @return
     */
    @RequestMapping(value = "findDrugSupplierById",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "supplierId")Long supplierId, HttpSession session,Model model){
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        if (null != supplierId){
            DrugSupplier drugSupplier = drugSupplierService.findById(supplierId);
            model.addAttribute("drugSupplier",drugSupplier);
        }
        return "drugsSupplierEdit";
    }


    /**
     *  新增,修改 保存
     * @param drugSupplier
     * @return
     */
    @RequestMapping(value ="saveDrugSupplier" ,method = RequestMethod.POST)
    public String save(DrugSupplier drugSupplier,HttpSession session,Model model){
        Long userId=(Long) session.getAttribute("userId");
        drugSupplier.setCreateUserid(userId);
        Timestamp time=new Timestamp(System.currentTimeMillis());
        drugSupplier.setCreateDate(time);
        drugSupplierService.save(drugSupplier);

        model.addAttribute("success","添加成功");
        return "/findDrugSupplierAll";
    }

    /**
     * 删除
     * @param supplierId
     * @return
     */
    @RequestMapping(value = "deleteDrugSupplierById",method = RequestMethod.GET)
    public String deleteById(@PathVariable(value = "supplierId")Long supplierId,Model model) {
        drugSupplierService.deleteById(supplierId);
        model.addAttribute("success","删除成功");
        return "/findDrugSupplierAll";
    }



    /**
     * 查看 详情
     * @param supplierId
     * @param session
     * @return
     */
    @RequestMapping(value = "goDrugsSupplierDetail",method = RequestMethod.GET)
    public String update(@PathVariable(value = "supplierId")Long supplierId,HttpSession session,Model model) {
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        DrugSupplier drugSupplier = drugSupplierService.findById(supplierId);
        model.addAttribute("drugSupplier",drugSupplier);

        return "drugs/drugsSupplierDetail";
    }

}
