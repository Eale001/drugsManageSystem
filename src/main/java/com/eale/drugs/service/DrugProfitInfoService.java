package com.eale.drugs.service;

import com.eale.drugs.bean.DrugProfitInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugProfitInfoService {

    /**
     * 根据Id查询
     * @param profitinfoId
     * @return
     */
    DrugProfitInfo findById(Long profitinfoId);


    /**
     * 添加
     * @param profitinfoId
     */
    void saveById(DrugProfitInfo profitinfoId);

    /**
     * 删除
     * @param profitinfoId
     */
    void deleteById(Long profitinfoId);


    /**
     * 查询全部
     */
    List<DrugProfitInfo> findAll();

    /**
     * 修改
     * @param drugProfitInfo
     * @return
     */
    DrugProfitInfo update(DrugProfitInfo drugProfitInfo);















}
