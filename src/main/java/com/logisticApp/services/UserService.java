package com.logisticApp.services;


import com.logisticApp.dto.SystemUser;
import com.logisticApp.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(SystemUser systemUser);
    User getCurrentUser();
}
