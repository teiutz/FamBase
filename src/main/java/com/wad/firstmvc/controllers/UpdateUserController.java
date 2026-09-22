package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateUserController {
    private final UserService userService;

    public UpdateUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/change-username")
    public String showUpdateUsernameForm(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("currentUsername", currentUser.getUsername());
        return "users/changeUsername";
    }

    @PostMapping("/change-username")
    public String updateUsername(@AuthenticationPrincipal User currentUser, @RequestParam String newUsername) {
        currentUser.setUsername(newUsername);
        userService.save(currentUser);
        return "redirect:/all";
    }

}
