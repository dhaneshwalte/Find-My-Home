package com.project.group17.prefValues.service;

import com.project.group17.prefValues.Repository.PrefValuesRepository;
import com.project.group17.prefValues.entity.PrefValuesEntity;
import com.project.group17.prefValues.mapper.PrefValuesMapper;
import com.project.group17.prefValues.model.PrefValueSaveReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrefValuesService {

    @Autowired
    PrefValuesRepository repository;
    public String saveUserPreferences(int userId, List<PrefValueSaveReq> userPrefs){
        List<PrefValuesEntity> prefValuesEntities = new ArrayList<>();
        for(PrefValueSaveReq userPref: userPrefs)
            prefValuesEntities.add(PrefValuesMapper.saveReqToEntityMapper(userPref, userId));

        repository.saveAll(prefValuesEntities);
        return "Success";
    }

    public List<PrefValuesEntity> findAll(){
        return repository.findAll();
    }
}
