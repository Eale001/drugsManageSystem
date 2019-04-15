package com.eale.drugs.dao;

import com.eale.drugs.bean.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugsDao extends JpaRepository<Drugs,Long> {
}
