package com.tea.fambase.controllers;

import com.tea.fambase.domain.User;
import com.tea.fambase.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/family")
public class FamilyMembersController {
  private final UserRepository userRepository;

  public FamilyMembersController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public String getMembers(Model model, @AuthenticationPrincipal User currentUser){
    model.addAttribute("familyMembers", userRepository.findAllByFamily(currentUser.getFamily()));
    return "family/getMembers";
  }
}

