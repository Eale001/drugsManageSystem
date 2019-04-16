package com.eale.drugs.controller.drugs;

import com.eale.drugs.bean.DrugCate;
import com.eale.drugs.bean.Drugs;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.DrgusVO;
import com.eale.drugs.common.formValid.ResultEnum;
import com.eale.drugs.common.formValid.ResultVO;
import com.eale.drugs.service.DrugCateService;
import com.eale.drugs.service.DrugsService;
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

/**
 * 药品信息controller
 */
@Controller
@RequestMapping("/")
public class DrugsController {

    @Autowired
    private DrugsService drugsService;

    @Autowired
    private DrugCateService drugCateService;

    @Autowired
    private UserService userService;

    /**
     * 进入到 药品列表
     * @return
     */
    @RequestMapping(value = "findDrgusAll",method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Drugs> drugsList= drugsService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (Drugs drugs : drugsList) {
            DrgusVO drgusVO = new DrgusVO();
            DrugCate cate = drugCateService.findById(drugs.getCateId());
            drgusVO.setDrugCate(cate);
            drgusVO.setDrugs(drugs);
            User user =userService.findById(drugs.getCreateUserid());
            drgusVO.setUserName(user.getUserName());
            drgusVOSList.add(drgusVO);
        }
        model.addAttribute("drgusVOSList",drgusVOSList);

        return "drugs/drugsManage";
    }


    /**
     * 进入 新增,修改页面
     * @param drugsId
     * @return
     */
    @RequestMapping(value = "findDrugsById",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "drugsId")Long drugsId, Model model, HttpSession session){
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        if (drugsId!=null){
            Drugs drugs = drugsService.findById(drugsId);
            DrugCate cate = drugCateService.findById(drugs.getCateId());
            DrgusVO drgusVO = new DrgusVO();
            drgusVO.setDrugCate(cate);
            drgusVO.setDrugs(drugs);
            model.addAttribute("drugs",drgusVO);
        }
        List<DrugCate> drugCateList = drugCateService.findAll();
        model.addAttribute("drugsCateList",drugCateList);
        return "drugs/drugsEdit";
    }


    /**
     *  新增,修改 保存
     * @param drugs
     * @return
     */
    @RequestMapping(value ="saveDrugs" ,method = RequestMethod.POST)
    public String saveById(Drugs drugs,HttpSession session, Model model){
        System.out.println(drugs);
        Long userId=(Long) session.getAttribute("userId");
        drugs.setCreateUserid(userId);
        Timestamp time=new Timestamp(System.currentTimeMillis());
        drugs.setCreateDate(time);
        drugsService.saveById(drugs);

//        if (null == drugs){
//            return new ResultVO(ResultEnum.ERROR.getCode(),"数据有误");
//        }
        model.addAttribute("success","操作成功");
        return "/findDrgusAll";
    }

    /**
     * 删除
     * @param drugsId
     * @return
     */
    @RequestMapping(value = "deleteDrugsById",method = RequestMethod.GET)
    public String deleteById(@PathVariable(value = "drugsId")Long drugsId,Model model) {
        drugsService.deleteById(drugsId);
        model.addAttribute("success","删除成功");
        return "/findDrgusAll";
    }




    /**
     * 查看 药品 详情
     * @param drugsId
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "goDrugsDetail",method = RequestMethod.GET)
    public String update(@PathVariable(value = "drugsId")Long drugsId,HttpSession session, Model model) {
        Long userId =(Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user",user);

        Drugs drugs = drugsService.findById(drugsId);
        DrugCate cate = drugCateService.findById(drugs.getCateId());
        DrgusVO drgusVO = new DrgusVO();
        drgusVO.setDrugCate(cate);
        drgusVO.setDrugs(drugs);
        model.addAttribute("drugs",drgusVO);

        return "drugs/drugsDetail";
    }


}
