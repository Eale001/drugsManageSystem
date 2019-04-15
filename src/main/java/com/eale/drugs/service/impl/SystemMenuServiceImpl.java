package com.eale.drugs.service.impl;

import com.eale.drugs.bean.Rolemenu;
import com.eale.drugs.bean.SystemMenu;
import com.eale.drugs.bean.User;
import com.eale.drugs.dao.RolepowerlistDao;
import com.eale.drugs.dao.SystemMenuDao;
import com.eale.drugs.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private SystemMenuDao systemMenuDao;

    @Autowired
    private RolepowerlistDao rolepowerlistDao;

    @Override
    public List<SystemMenu> findall() {
        return systemMenuDao.findall();
    }

    @Override
    public void findAllMenuSys(HttpServletRequest req) {
        //		查找所有父级
        Iterable<SystemMenu> oneMenuAll=systemMenuDao.findByParentIdOrderBySortId(0L);
//		查找所有子级
        Iterable<SystemMenu> twoMenuAll=systemMenuDao.findByParentIdNotOrderBySortId(0L);

        req.setAttribute("oneMenuAll", oneMenuAll);
        req.setAttribute("twoMenuAll", twoMenuAll);

    }

    @Override
    public List<SystemMenu> findByMenuNameLike(String name) {
        return systemMenuDao.findByMenuNameLike(name);
    }

    @Override
    public int changeSortId(Integer sortId, Integer arithNum, Long parentId) {
        return systemMenuDao.changeSortId(sortId,arithNum,parentId);
    }

    @Override
    public int changeSortId2(Integer sortId, Integer arithNum, Long menuId) {
        return systemMenuDao.changeSortId2(sortId,arithNum,menuId);
    }

    @Override
    public void findMenuSys(HttpServletRequest req, User user) {
        List<Rolemenu> oneMenuAll=rolepowerlistDao.findbyparentxianall(0L, user.getRole().getRoleId(), true,true);
        List<Rolemenu> twoMenuAll=rolepowerlistDao.findbyparentsxian(0L, user.getRole().getRoleId(), true,true);
        req.setAttribute("oneMenuAll", oneMenuAll);
        req.setAttribute("twoMenuAll", twoMenuAll);
    }

    @Override
    public List<SystemMenu> findByParentIdOrderBySortId(long id) {
        return systemMenuDao.findByParentIdOrderBySortId(id);
    }

    @Override
    public SystemMenu findById(Long getId) {
        return systemMenuDao.findById(getId).get();
    }

    @Override
    public void save(SystemMenu menu) {
        systemMenuDao.save(menu);
    }

    @Override
    public int deleteThis(Long menuId) {
        return systemMenuDao.deleteThis(menuId);
    }
}
