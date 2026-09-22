package com.tea.fambase.controllers;

import com.tea.fambase.domain.AvatarImage;
import com.tea.fambase.domain.Family;
import com.tea.fambase.domain.Role;
import com.tea.fambase.domain.User;
import com.tea.fambase.repository.AvatarImageRepository;
import com.tea.fambase.services.FamilyService;
import com.tea.fambase.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisterController {
    private final UserService userService;
    private final FamilyService familyService;
    private final AvatarImageRepository avatarImageRepository;
    private final PasswordEncoder bcrypt = new BCryptPasswordEncoder();

    public RegisterController(UserService userService, FamilyService familyService, AvatarImageRepository avatarImageRepository) {
        this.userService = userService;
        this.familyService = familyService;
        this.avatarImageRepository = avatarImageRepository;
    }

    @GetMapping("/register")
    public String getImages(Model model) {
        System.out.println("REGISTER GET CONTROLLER REACHED");

        List<AvatarImage> avatarImages = avatarImageRepository.findAll();

        model.addAttribute("avatars", avatarImages);
        model.addAttribute("user", new User());

        return "account/register";
    }


    @PostMapping("/register")
    public String register(@RequestParam("username") String user, @RequestParam("password") String password, @RequestParam("gender") String gender, @RequestParam("role") String role, @RequestParam("familyName") String familyName, @RequestParam("avatarId") Long avatarId, Model model) {
        User newUser = new User(user, bcrypt.encode(password), gender);
        newUser.setRole(Role.valueOf(role));

        if (userService.usernameExists(newUser.getUsername())) {
            model.addAttribute("usernameError", "Username already exists");
            return "account/register";
        } else {
            Family newFamily = new Family(familyName);
            familyService.save(newFamily);
            newUser.setFamily(newFamily);
            System.out.println(newUser);

            AvatarImage avatar = avatarImageRepository.findAvatarImageById(avatarId);


            newUser.setAvatarImage(avatar);
            userService.save(newUser);


            return "redirect:/account/login";
        }
    }
}
