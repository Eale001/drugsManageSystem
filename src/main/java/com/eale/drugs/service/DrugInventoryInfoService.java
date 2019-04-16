package com.eale.drugs.service;

import com.eale.drugs.bean.DrugInventoryInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugInventoryInfoService {

    /**
     * 查询Id
     * @param inventoryinfoId
     * @return
     */
    DrugInventoryInfo findById(Long inventoryinfoId);


    /**
     * 添加
     * @param inventoryinfoId
     */
    void saveById(DrugInventoryInfo inventoryinfoId);

    /**
     * 删除
     * @param inventoryinfoId
     */
    void deleteById(Long inventoryinfoId);


    /**
     * 查询全部
     */
    List<DrugInventoryInfo> findAll();

    /**
     * 修改
     * @param drugInventoryInfo
     * @return
     */
    DrugInventoryInfo update(DrugInventoryInfo drugInventoryInfo);

    /**
     * 根据药品查询
     * @param drugsId
     * @return
     */
    DrugInventoryInfo findByDrugsId(Long drugsId);
}
