package com.eale.drugs.service.impl;

import com.eale.drugs.bean.Drugs;
import com.eale.drugs.dao.DrugsDao;
import com.eale.drugs.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugsServiceImpl implements DrugsService {

    @Autowired
    private DrugsDao drugsDao;

    @Override
    public Drugs findById(Long drugsId) {
        return drugsDao.findById(drugsId).get();
    }

    @Override
    public void saveById(Drugs drugs) {
        drugsDao.save(drugs);
    }

    @Override
    public void deleteById(Long drugsId) {
        drugsDao.deleteById(drugsId);
    }

    @Override
    public List<Drugs> findAll() {
        return drugsDao.findAll();
    }

    @Override
    public Drugs update(Drugs drugs) {
        drugsDao.save(drugs);
        return drugsDao.findById(drugs.getDrugsId()).get();
    }
}
