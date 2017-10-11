package com.macro.dev.service;

import com.macro.dev.models.TcOrg;
import com.macro.dev.models.TcRole;
import com.macro.dev.models.TcUser;
import com.macro.dev.repositories.OrgRepository;
import com.macro.dev.repositories.RoleRepository;
import com.macro.dev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrgRepository orgRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(TcUser user){
        user.setUserPw(passwordEncoder().encode(user.getUserPw()));
        userRepository.save(user);
    }

    public void saveOrg(TcOrg org){
        orgRepository.save(org);
    }
    public void saveRole(TcRole role){
        roleRepository.save(role);
    }

   /* public List<TcUser> getAllRoles() {
        return userRepository.findAll();
    }*/

    public TcUser getUser(String username){
        return userRepository.findByUsername(username);
    }

    /*public List<TcUser> getAllUsers() {
        return userRepository.findAll();
    }*/

}
