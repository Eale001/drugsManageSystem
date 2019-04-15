package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugSaleInfo;
import com.eale.drugs.dao.DrugSaleInfoDao;
import com.eale.drugs.service.DrugSaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugSaleInfoServiceImpl implements DrugSaleInfoService {
    @Autowired
    private DrugSaleInfoDao drugSaleInfoDao;

    @Override
    public DrugSaleInfo findById(Long saleinfoId) {
        return drugSaleInfoDao.findById(saleinfoId).get();
    }

    @Override
    public void saveById(DrugSaleInfo saleinfoId) {
        drugSaleInfoDao.save(saleinfoId);

    }

    @Override
    public void deleteById(Long saleinfoId) {
        drugSaleInfoDao.deleteById(saleinfoId);

    }

    @Override
    public List<DrugSaleInfo> findAll() {
        return drugSaleInfoDao.findAll();
    }

    @Override
    public DrugSaleInfo update(DrugSaleInfo drugSaleInfo) {
        drugSaleInfoDao.save(drugSaleInfo);
        return drugSaleInfoDao.findById(drugSaleInfo.getSaleinfoId()).get();
    }
}
