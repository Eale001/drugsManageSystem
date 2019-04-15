package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugProfitInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugProfitInfoDao  extends JpaRepository<DrugProfitInfo,Long> {
}
