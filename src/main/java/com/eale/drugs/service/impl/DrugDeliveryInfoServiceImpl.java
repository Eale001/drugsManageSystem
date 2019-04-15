package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugDeliveryInfo;
import com.eale.drugs.dao.DrugDeliveryInfoDao;
import com.eale.drugs.service.DrugDeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class DrugDeliveryInfoServiceImpl implements DrugDeliveryInfoService {

    @Autowired
    private DrugDeliveryInfoDao drugDeliveryInfoDao;


    @Override
    public DrugDeliveryInfo findById(Long deliveryinfoId) {
        return drugDeliveryInfoDao.findById(deliveryinfoId).get();
    }

    @Override
    public void saveById(DrugDeliveryInfo deliveryinfoId) {
        drugDeliveryInfoDao.save(deliveryinfoId);
    }

    @Override
    public void deleteById(Long deliveryinfoId) {
        drugDeliveryInfoDao.deleteById(deliveryinfoId);

    }

    @Override
    public List<DrugDeliveryInfo> findAll() {
        return drugDeliveryInfoDao.findAll();
    }

    @Override
    public DrugDeliveryInfo update(DrugDeliveryInfo drugDeliveryInfo) {
        drugDeliveryInfoDao.save(drugDeliveryInfo);
        return drugDeliveryInfoDao.findById(drugDeliveryInfo.getDeliveryinfoId()).get();
    }
}
