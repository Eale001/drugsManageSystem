package com.eale.drugs.service.impl;

import com.eale.drugs.bean.DrugSupplier;
import com.eale.drugs.dao.DrugSupplierDao;
import com.eale.drugs.service.DrugSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugSupplierServiceImpl implements DrugSupplierService {
    @Autowired
    private DrugSupplierDao drugSupplierDao;

    @Override
    public DrugSupplier findById(Long supplierId) {
        return drugSupplierDao.findById(supplierId).get();
    }

    @Override
    public void deleteById(Long supplierId) {
        drugSupplierDao.deleteById(supplierId);
    }

    @Override
    public List<DrugSupplier> findAll() {
        return drugSupplierDao.findAll();
    }

    @Override
    public DrugSupplier update(DrugSupplier drugSupplier) {
       drugSupplierDao.save(drugSupplier);
        return drugSupplierDao.findById(drugSupplier.getSupplierId()).get();
    }

    @Override
    public void save(DrugSupplier drugSupplier) {
        drugSupplierDao.save(drugSupplier);

    }
}
