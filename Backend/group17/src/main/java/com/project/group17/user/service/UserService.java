package com.project.group17.user.service;

import org.springframework.stereotype.Service;

import com.project.group17.profilepage.controller.UserUpdateRequest;
import com.project.group17.user.entity.User;

@Service
public class UserService {

    public void saveEditUserDetails(UserUpdateRequest updatedUser  ,User principlUser) {
        principlUser.setFirstname(updatedUser.getFirstname());
        principlUser.setLastname(updatedUser.getLastname());
        principlUser.setGender(updatedUser.getGender());
        principlUser.setEmail(updatedUser.getEmail());
        principlUser.setStreetAddress(updatedUser.getStreetAddress());    
        principlUser.setCity(updatedUser.getCity());
        principlUser.setProvince(updatedUser.getProvince());
        principlUser.setPhoneNumber(updatedUser.getPhoneNumber());
        principlUser.setAge(updatedUser.getAge());
    }

}
