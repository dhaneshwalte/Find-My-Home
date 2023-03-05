package com.project.group17.prefNames.service;

import com.project.group17.prefNames.entity.prefNamesEntity;
import com.project.group17.prefNames.repository.PrefNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefNamesService {

    @Autowired
    PrefNamesRepository repository;

    public List<prefNamesEntity> getAllPrefOptions()
    {
        return repository.findAll();
    }
}
