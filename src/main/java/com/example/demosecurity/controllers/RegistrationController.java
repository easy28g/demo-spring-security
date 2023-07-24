package com.example.demosecurity.controllers;

import java.util.Collections;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import com.example.demosecurity.domains.Role;
import com.example.demosecurity.domains.User;
import com.example.demosecurity.repos.UserRepo;
import com.example.demosecurity.service.MailSender;
import com.example.demosecurity.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private MailSender mailSender;

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration.html";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivateCode(UUID.randomUUID().toString());
        userRepo.save(user);

        if(!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                "Hello, %s! \n" + 
                "Welcom to Sweater. Please, visit next link: http://localhost:8080/activate/%s",
                user.getUsername(),
                user.getActivateCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);
        
        if(isActivated){
            model.addAttribute("message", "User successfully activated!");
        }else{
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }
    
}
