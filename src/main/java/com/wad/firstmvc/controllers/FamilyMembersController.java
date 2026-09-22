package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Family;
import com.wad.firstmvc.domain.Role;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repository.FamilyRepository;
import com.wad.firstmvc.repository.UserRepository;
import com.wad.firstmvc.services.FamilyService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

