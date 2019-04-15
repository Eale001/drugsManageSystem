package com.eale.drugs.dao;

import com.eale.drugs.bean.DrugSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugSupplierDao extends JpaRepository<DrugSupplier,Long> {
}
