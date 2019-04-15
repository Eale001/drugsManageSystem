package com.eale.drugs.service;


import com.eale.drugs.bean.DrugDeliveryInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugDeliveryInfoService {

    /**
     * 根据Id查询
     * @param deliveryinfoId
     * @return
     */
    DrugDeliveryInfo findById(Long deliveryinfoId);


    /**
     * 添加
     * @param deliveryinfoId
     */
    void saveById(DrugDeliveryInfo deliveryinfoId);

    /**
     * 删除
     * @param deliveryinfoId
     */
    void deleteById(Long deliveryinfoId);

    /**
     * 查询全部
     */
    List<DrugDeliveryInfo> findAll();

    /**
     * 修改
     * @param drugDeliveryInfo
     */
    DrugDeliveryInfo update(DrugDeliveryInfo drugDeliveryInfo);
}

