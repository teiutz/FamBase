package com.tea.fambase.controllers;
import com.tea.fambase.domain.Event;
import com.tea.fambase.domain.User;
import com.tea.fambase.repository.AvatarImageRepository;
import com.tea.fambase.services.EventService;
import com.tea.fambase.services.ShoppingItemService;
import com.tea.fambase.services.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/all")
public class AllController {
    private final EventService eventService;
    private final ShoppingItemService shoppingItemService;
    private final TaskService taskService;
    private final AvatarImageRepository avatarImageRepository;


    public AllController(EventService eventService, ShoppingItemService shoppingItemService, TaskService taskService, AvatarImageRepository avatarImageRepository) {
        this.eventService = eventService;
        this.shoppingItemService = shoppingItemService;
        this.taskService = taskService;
        this.avatarImageRepository = avatarImageRepository;
    }

    @GetMapping
    public String viewAll(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("events", eventService.findByUserFamily(currentUser.getFamily()));
        model.addAttribute("shoppingItems", shoppingItemService.findByUserFamily(currentUser.getFamily()));
        model.addAttribute("tasks", taskService.findByUserFamily(currentUser.getFamily()));
        model.addAttribute("currentAvatar", avatarImageRepository.findAvatarImageById(currentUser.getAvatarImage().getId()));
        return "general/all";
    }

    @PostMapping
    public String allAddEvent(Model model,
                              @RequestParam(name = "startDate", required = false) String startDate,
                              @RequestParam(name = "endDate", required = false) String endDate) {
        if (startDate != null && endDate != null) {
            model.addAttribute("event", new Event(startDate, endDate));
        } else {
            model.addAttribute("event", new Event());
        }
        return "events/addevents";
    }
}
