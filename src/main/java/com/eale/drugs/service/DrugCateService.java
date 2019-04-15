package com.eale.drugs.service;

import com.eale.drugs.bean.DrugCate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugCateService {

    /**
     * 根据Id查询
     * @param cateId
     * @return
     */
    DrugCate findById(Long cateId);

    /**
     * 添加
     * @param cateId
     */
    void saveById(DrugCate cateId);

    /**
     * 删除
     * @param cateId
     */
    void deleteById(Long cateId);

    /**
     * 查询全部
     */
    List<DrugCate>findAll();


    /**
     * 修改
     * @param drugCate
     */
    DrugCate update(DrugCate drugCate);
}
