package com.eale.drugs.controller;

import com.eale.drugs.bean.DrugInventoryInfo;
import com.eale.drugs.bean.Drugs;
import com.eale.drugs.bean.Rolemenu;
import com.eale.drugs.bean.User;
import com.eale.drugs.common.DrgusVO;
import com.eale.drugs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private SystemMenuService systemMenuService;

    @Autowired
    private UserService userService;

    @Autowired
    private RolepowerlistService rolepowerlistService;

    @Autowired
    private DrugInventoryInfoService drugInventoryInfoService;

    @Autowired
    private DrugsService drugsService;


    @RequestMapping("index")
    public String index(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if(StringUtils.isEmpty(session.getAttribute("userId"))){
            return "login/login";
        }
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        User user=userService.findById(userId);

        systemMenuService.findMenuSys(req,user);

        model.addAttribute("user", user);
        //展示用户操作记录 由于现在没有登陆 不能获取用户id
        return "index/index";
    }
    /**
     * 菜单查找
     * @param model
     * @param req
     * @return
     */
    @RequestMapping("menucha")
    public String menucha(HttpSession session, Model model, HttpServletRequest req){
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        User user=userService.findById(userId);

        String val=null;
        if(!StringUtils.isEmpty(req.getParameter("val"))){
            val=req.getParameter("val");
        }
        if(!StringUtils.isEmpty(val)){
//			List<Rolemenu> oneMenuAll=rdao.findname(0L, user.getRole().getRoleId(), true, true, val);//找父菜单
            List<Rolemenu> oneMenuAll=rolepowerlistService.findname(0L, user.getRole().getRoleId(), true, true, val);//找父菜单


            List<Rolemenu> twoMenuAll=null;
            for (int i = 0; i < oneMenuAll.size(); i++) {
                twoMenuAll=rolepowerlistService.findbyparentsxian(oneMenuAll.get(i).getMenuId(), user.getRole().getRoleId(), true, true);//找子菜单
            }
            req.setAttribute("oneMenuAll", oneMenuAll);
            req.setAttribute("twoMenuAll", twoMenuAll);
        }else{
            systemMenuService.findMenuSys(req,user);
        }

        return "common/leftlists";

    }

    /**
     * 控制面板主页
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("test2")
    public String test2(HttpSession session, Model model, HttpServletRequest request) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        User user=userService.findById(userId);
        request.setAttribute("user", user);
        //计算三个模块的记录条数

        model.addAttribute("user", user);

        List<DrugInventoryInfo> drugInventoryInfoList= drugInventoryInfoService.findAll();
        List<DrgusVO> drgusVOSList=new ArrayList<>();
        for (DrugInventoryInfo drugInventoryInfo : drugInventoryInfoList) {
            DrgusVO drgusVO = new DrgusVO();
            Drugs drugs = drugsService.findById(drugInventoryInfo.getDrugsId());
            drgusVO.setDrugs(drugs);
            drgusVO.setDrugInventoryInfo(drugInventoryInfo);
            User user1 =userService.findById(drugInventoryInfo.getCreateUserid());
            drgusVO.setUserName(user.getUserName());
            drgusVOSList.add(drgusVO);
        }

        model.addAttribute("drgusVOSList",drgusVOSList);

        return "systemcontrol/control";
    }

}

