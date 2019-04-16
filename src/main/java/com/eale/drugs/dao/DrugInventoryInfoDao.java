package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugInventoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugInventoryInfoDao  extends JpaRepository<DrugInventoryInfo,Long> {

    DrugInventoryInfo findByDrugsId(Long drugsId);
}
