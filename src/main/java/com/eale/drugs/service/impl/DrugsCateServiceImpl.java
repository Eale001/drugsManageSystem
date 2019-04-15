package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugCate;
import com.eale.drugs.dao.DrugCateDao;
import com.eale.drugs.service.DrugCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugsCateServiceImpl implements DrugCateService {

    @Autowired
    private DrugCateDao drugCateDao;

    @Override
    public DrugCate findById(Long cateId) {
        return drugCateDao.findById(cateId).get();
    }

    @Override
    public void saveById(DrugCate cate) {
        drugCateDao.save(cate);
    }

    @Override
    public void deleteById(Long cateId) {
        drugCateDao.deleteById(cateId);
    }

    @Override
    public List<DrugCate> findAll() {
        return drugCateDao.findAll();
    }

    @Override
    public DrugCate update(DrugCate drugCate) {
        drugCateDao.save(drugCate);
        return drugCateDao.findById(drugCate.getCateId()).get();
    }
}
