package com.macro.dev;

import com.macro.dev.config.CustomUserDetails;
import com.macro.dev.models.TcOrg;
import com.macro.dev.models.TcRole;
import com.macro.dev.models.TcUser;
import com.macro.dev.repositories.OrgRepository;
import com.macro.dev.repositories.UserRepository;
import com.macro.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient
public class AuthorizationServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder auth, UserRepository repository, OrgRepository orep, UserService userService) throws Exception {
        if (repository.count()==0 && orep.count()==0) {

            TcOrg org = new TcOrg();
            org.setOrgNm("gcomm");
            org.setTelNo("99203116");
            userService.saveOrg(org);

            TcRole rl= new TcRole();
            rl.setRoleNmEng("ADMIN");
            userService.saveRole(rl);

            List<TcRole> roles= new ArrayList<>();
            roles.add(rl);
            userService.save(new TcUser("admin", "adminPassword", org));



        }
      //  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        auth.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }
}