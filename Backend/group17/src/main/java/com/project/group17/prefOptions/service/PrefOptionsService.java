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

    /**
     * Returns a list of all preference options.
     *
     * @return List<PrefOptionsEntity> - a list of preference options
     */
    public List<PrefOptionsEntity> getAllPrefOptions()
    {
        // Call the findAll method in the repository to get all preference options
        return prefOptionsRepository.findAll();
    }
}
