package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Family;
import com.wad.firstmvc.domain.Role;
import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repository.UserRepository;
import com.wad.firstmvc.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
  private final UserRepository userRepository;

  public AdminController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public String showAddUserForm(Model model) {
    model.addAttribute("user", new User());
    return "account/admin";
  }

  @PostMapping
  public String addUserToFamily(@RequestParam String username, @AuthenticationPrincipal User currentUser, Model model){
    User foundUser = userRepository.findByUsername(username);
    if(foundUser == null){
      model.addAttribute("notFoundUserError", "user with that username not found");
    }
    else{
      Family currentFamily = currentUser.getFamily();
      System.out.println(currentFamily.getName());

      if (foundUser.getRole().equals(Role.ROLE_USER)) {
        foundUser.setFamily(currentFamily);
        userRepository.save(foundUser);

      } else {
        model.addAttribute("incorrectRoleError", "the added user should not have ADMIN role");
      }
    }
      return "account/admin";
  }

}