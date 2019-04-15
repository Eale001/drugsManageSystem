package com.eale.drugs.service;

import com.eale.drugs.bean.DrugIncomingInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DrugIncomingInfoService {

    /**
     * 根据Id查询
     * @param incominginfoId
     * @return
     */
    DrugIncomingInfo findById(Long incominginfoId);

    /**
     * 添加
     * @param incomingInfoId
     */
    void saveById(DrugIncomingInfo incomingInfoId);


    /**
     * 删除
     * @param incomingInfoId
     */
    void deleteById(Long incomingInfoId);



    /**
     *查询全部
     */
    List<DrugIncomingInfo>findAll();


    /**
     * 修改
     * @param drugIncomingInfo
     * @return
     */
    DrugIncomingInfo update(DrugIncomingInfo drugIncomingInfo);
}
