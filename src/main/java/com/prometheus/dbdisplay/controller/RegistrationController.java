package com.prometheus.dbdisplay.controller;

import com.prometheus.dbdisplay.domain.Admin;
import com.prometheus.dbdisplay.domain.Role;
import com.prometheus.dbdisplay.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private AdminRepo adminRepo;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addAdmin(Admin admin, Map<String, Object> model){
        Admin adminFromDb =  adminRepo.findByUsername(admin.getUsername());
        if(adminFromDb != null){
            model.put("massage", "Admin exist!");
            return "registration";

        }
        admin.setActive(true);
        admin.setRoles(Collections.singleton(Role.ADMIN));
        adminRepo.save(admin);


        return "redirect:/login";

    }
}

