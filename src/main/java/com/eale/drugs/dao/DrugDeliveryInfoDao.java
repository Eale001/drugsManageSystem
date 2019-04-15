package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugDeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugDeliveryInfoDao  extends JpaRepository<DrugDeliveryInfo,Long> {
}
