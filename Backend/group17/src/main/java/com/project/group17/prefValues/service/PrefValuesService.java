package com.project.group17.prefValues.service;

import com.project.group17.prefValues.repository.PrefValuesRepository;
import com.project.group17.prefValues.entity.PrefValuesEntity;
import com.project.group17.prefValues.mapper.PrefValuesMapper;
import com.project.group17.prefValues.model.PrefValueSaveReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrefValuesService {

    @Autowired
    PrefValuesRepository repository;
    public String saveUserPreferences(int userId, List<PrefValueSaveReq> userPrefs){
        List<PrefValuesEntity> prefValuesEntities = new ArrayList<>();
        for(PrefValueSaveReq userPref: userPrefs){
            PrefValuesEntity prefValuesEntity = PrefValuesMapper.saveReqToEntityMapper(userPref, userId);
            Optional<PrefValuesEntity> dataFromDB = repository.findByUserAndPrefName(prefValuesEntity.getUser().getId(), prefValuesEntity.getPrefValueId());

            if(dataFromDB.isPresent()){
                prefValuesEntity.setPrefValueId(dataFromDB.get().getPrefValueId());
            }
            prefValuesEntities.add(PrefValuesMapper.saveReqToEntityMapper(userPref, userId));
        }
        repository.saveAll(prefValuesEntities);
        return "Success";
    }

    public List<PrefValueSaveReq> getUserPrefValuesById(int userId){
        try{
            List<PrefValueSaveReq> prefRes = new ArrayList<>();
            List<Optional<PrefValuesEntity>> prefDB = repository.getAllByUserId(userId);
            if(!prefDB.isEmpty())
                for(Optional<PrefValuesEntity> pref: prefDB){
                    if(pref.isPresent())
                        prefRes.add(PrefValuesMapper.entittyToGetPrefCRes(pref.get()));
            }
            System.out.println("prefRes" + prefRes);
            return prefRes;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return new ArrayList<>();
        }

    }
}
