package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugInventoryInfo;
import com.eale.drugs.dao.DrugInventoryInfoDao;
import com.eale.drugs.dao.DrugsDao;
import com.eale.drugs.service.DrugInventoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugInventoryInfoServiceImpl implements DrugInventoryInfoService{
    @Autowired
    private DrugInventoryInfoDao drugInventoryInfoDao;

    @Override
    public DrugInventoryInfo findById(Long inventoryinfoId) {
        return drugInventoryInfoDao.findById(inventoryinfoId).get();
    }

    @Override
    public void saveById(DrugInventoryInfo inventoryinfoId) {
        drugInventoryInfoDao.save(inventoryinfoId);
    }

    @Override
    public void deleteById(Long inventoryinfoId) {
        drugInventoryInfoDao.deleteById(inventoryinfoId);

    }

    @Override
    public List<DrugInventoryInfo> findAll() {
        return drugInventoryInfoDao.findAll();
    }

    @Override
    public DrugInventoryInfo update(DrugInventoryInfo drugInventoryInfo) {
        drugInventoryInfoDao.save(drugInventoryInfo);
        return drugInventoryInfoDao.findById(drugInventoryInfo.getDrugsId()).get();
    }
}
