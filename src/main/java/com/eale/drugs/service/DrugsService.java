package com.eale.drugs.service;


import com.eale.drugs.bean.Drugs;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugsService {
    /**
     * 根据Id查询
     * @param drugsId
     * @return
     */
    Drugs findById(Long drugsId);

    /**
     * 添加
     * @param drugsId
     */
    void saveById(Drugs drugsId);

    /**
     * 删除
     * @param drugsId
     */
    void deleteById(Long drugsId);

    /**
     * 查询全部
     */
    List<Drugs> findAll();

    /**
     * 修改
     * @param drugs
     */
    Drugs update(Drugs drugs);
}
