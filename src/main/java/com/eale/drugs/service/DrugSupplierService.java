package com.eale.drugs.service;

import com.eale.drugs.bean.DrugSupplier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugSupplierService {

    /**
     * 根据Id查询
     * @param supplierId
     * @return
     */
    DrugSupplier findById(Long supplierId);


    /**
     * 删除
     * @param supplierId
     */
    void deleteById(Long supplierId);

    /**
     * 查询全部
     */
    List<DrugSupplier>findAll();

    /**
     * 修改
     * @param drugSupplier
     * @return
     */
    DrugSupplier update(DrugSupplier drugSupplier);


    /**
     * 添加
     * @param drugSupplier
     */
    void save(DrugSupplier drugSupplier);
}
