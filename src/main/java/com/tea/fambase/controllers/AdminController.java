package com.tea.fambase.controllers;

import com.tea.fambase.domain.Family;
import com.tea.fambase.domain.Role;
import com.tea.fambase.domain.User;
import com.tea.fambase.repository.UserRepository;
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