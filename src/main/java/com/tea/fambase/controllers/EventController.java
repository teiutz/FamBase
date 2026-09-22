package com.tea.fambase.controllers;

import com.tea.fambase.domain.Event;
import com.tea.fambase.domain.User;
import com.tea.fambase.services.EventService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String viewEvents(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("events",eventService.findByUserFamily(currentUser.getFamily()));
        return "general/all";
    }

    @GetMapping("/new")
    public String showAddEventForm(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            Model model) {



        if(startDate != null & endDate != null){
            System.out.println("startDate: " + startDate);
            System.out.println("endDate: " + endDate);

            Event event = new Event(startDate, endDate);

            System.out.println("event start: " + event.getStartDate());
            System.out.println("event end: " + event.getEndDate());


            model.addAttribute("event", event);
        }
        else{
            Event event = new Event();
            model.addAttribute("event", event);
        }

        return "events/addevents";
    }

    @PostMapping({"/new", "/new/{startDate}/{endDate}"})
    public String addEvent(Event event, @AuthenticationPrincipal User currentUser) {
        if (Objects.equals(event.getName(), ""))
            event.setName("Unnamed");
        if (Objects.equals(event.getType(), ""))
            event.setType("None");

        if (event.getId() == null)
            event.setId(new Random().nextLong());

        event.setUser(currentUser);

        eventService.save(event);
        return "redirect:/events/allevents";
    }

    @GetMapping("/delete")
    public String deleteEvent(@RequestParam("id") String id) {
        Event event = eventService.findById(Long.parseLong(id));
        eventService.delete(event);
        return "redirect:/events/allevents";
    }

    @GetMapping("/allevents")
    public String showEventsPage(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("events", eventService.findByUserFamily(currentUser.getFamily()));

        return "events/events";
    }


}
