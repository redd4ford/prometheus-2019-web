package com.prometheus.dbdisplay.controller;

import com.prometheus.dbdisplay.domain.Admin;
import com.prometheus.dbdisplay.domain.Role;
import com.prometheus.dbdisplay.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
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
    public String addAdmin(@RequestParam String username, @RequestParam String password, Map<String, Object> model) throws ParseException {
        Admin adminFromDb =  adminRepo.findByUsername(username);
        if(adminFromDb != null){
            model.put("message", "Admin exists!");
            return "registration";

        }
        Admin admin = new Admin(username, password, false);
        admin.setActive(true);
        admin.setRole(Collections.singleton(Role.ADMIN));
        adminRepo.save(admin);

        return "redirect:/login";
    }
}

