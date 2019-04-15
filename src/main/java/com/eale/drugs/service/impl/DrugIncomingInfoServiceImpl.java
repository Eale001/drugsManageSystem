package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugIncomingInfo;
import com.eale.drugs.dao.DrugIncomingInfoDao;
import com.eale.drugs.service.DrugIncomingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugIncomingInfoServiceImpl implements DrugIncomingInfoService {

    @Autowired
    private DrugIncomingInfoDao drugIncomingInfoDao;


    @Override
    public DrugIncomingInfo findById(Long incominginfoId) {
        return drugIncomingInfoDao.findById(incominginfoId).get();
    }

    @Override
    public void saveById(DrugIncomingInfo incomingInfoId) {
        drugIncomingInfoDao.save(incomingInfoId);

    }

    @Override
    public void deleteById(Long incomingInfoId) {
        drugIncomingInfoDao.deleteById(incomingInfoId);

    }

    @Override
    public List<DrugIncomingInfo> findAll() {
        return drugIncomingInfoDao.findAll();
    }

    @Override
    public DrugIncomingInfo update(DrugIncomingInfo drugIncomingInfo) {
        drugIncomingInfoDao.save(drugIncomingInfo);
        return drugIncomingInfoDao.findById(drugIncomingInfo.getIncominginfoId()).get();
    }
}
