package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugSaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugSaleInfoDao extends JpaRepository<DrugSaleInfo,Long> {
}
