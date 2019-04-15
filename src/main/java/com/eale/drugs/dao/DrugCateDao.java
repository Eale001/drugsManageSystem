package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugCate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugCateDao extends JpaRepository<DrugCate,Long> {
}
