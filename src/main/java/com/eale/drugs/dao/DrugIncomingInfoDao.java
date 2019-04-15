package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugIncomingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugIncomingInfoDao  extends JpaRepository<DrugIncomingInfo,Long> {
}
