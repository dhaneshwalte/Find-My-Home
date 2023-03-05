package com.project.group17.prefOptions.service;

import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.prefOptions.repository.PrefOptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefOptionsService {
    @Autowired
    PrefOptionsRepository prefOptionsRepository;

    public List<PrefOptionsEntity> getAllPrefOptions()
    {
        return prefOptionsRepository.findAll();
    }
}
