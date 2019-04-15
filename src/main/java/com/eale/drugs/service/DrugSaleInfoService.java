package com.eale.drugs.service;

import com.eale.drugs.bean.DrugSaleInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugSaleInfoService {

    /**
     * 根据Id查询
     * @param saleinfoId
     * @return
     */
    DrugSaleInfo findById(Long saleinfoId);


    /**
     * 添加
     * @param saleinfoId
     */
    void saveById(DrugSaleInfo saleinfoId);

    /**
     * 删除
     * @param saleinfoId
     */
    void deleteById(Long saleinfoId);

    /**
     * 查询全部
     */
    List<DrugSaleInfo>findAll();


    /**
     * 修改
     * @param drugSaleInfo
     * @return
     */
    DrugSaleInfo update(DrugSaleInfo drugSaleInfo);



}
