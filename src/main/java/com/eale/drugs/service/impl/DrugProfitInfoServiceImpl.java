package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugProfitInfo;
import com.eale.drugs.dao.DrugProfitInfoDao;
import com.eale.drugs.service.DrugProfitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugProfitInfoServiceImpl implements DrugProfitInfoService {

    @Autowired
    private DrugProfitInfoDao drugProfitInfoDao;

    @Override
    public DrugProfitInfo findById(Long profitinfoId) {
        return drugProfitInfoDao.findById(profitinfoId).get();
    }

    @Override
    public void saveById(DrugProfitInfo profitinfo){
        drugProfitInfoDao.save(profitinfo);
    }

    @Override
    public void deleteById(Long profitinfoId) {
        drugProfitInfoDao.deleteById(profitinfoId);

    }

    @Override
    public List<DrugProfitInfo> findAll() {
        return drugProfitInfoDao.findAll();
    }

    @Override
    public DrugProfitInfo update(DrugProfitInfo drugProfitInfo) {
        drugProfitInfoDao.save(drugProfitInfo);
        return drugProfitInfoDao.findById(drugProfitInfo.getDrugsId()).get();
    }
}
