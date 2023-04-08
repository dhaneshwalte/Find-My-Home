package com.project.group17.profilepage.service;

import com.project.group17.profilepage.controller.UserUpdateRequest;
import com.project.group17.user.entity.User;
import com.project.group17.profilepage.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profilerepo;
    public void saveEditUserDetails(UserUpdateRequest updatedUser  , User principlUser) {
        principlUser.setFirstname(updatedUser.getFirstname());
        principlUser.setLastname(updatedUser.getLastname());
        principlUser.setGender(updatedUser.getGender());
        principlUser.setEmail(updatedUser.getEmail());
        principlUser.setStreetAddress(updatedUser.getStreetAddress());
        principlUser.setCity(updatedUser.getCity());
        principlUser.setProvince(updatedUser.getProvince());
        principlUser.setPhoneNumber(updatedUser.getPhoneNumber());
        principlUser.setAge(updatedUser.getAge());
        System.out.println(principlUser);
        profilerepo.saveEditUserDetails(principlUser);
    }
    

}
