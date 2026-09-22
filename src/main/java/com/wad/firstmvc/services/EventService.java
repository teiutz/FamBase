package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Event;
import com.wad.firstmvc.domain.Family;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repository.EventRepository;
import com.wad.firstmvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public Event findById(Long id) {
        Optional<Event> eventt = eventRepository.findById(id);
        return eventt.orElse(null);
    }

    public void delete(Event event) {
        eventRepository.delete(event);
    }

    public List<Event> findByType(String type) {
        return eventRepository.findByType(type);
    }

    public List<Event> findByUserFamily(Family family) {

        List<Event> events = new ArrayList<>();

        for (User user : userRepository.findAllByFamily(family)) {
            List<Event> userEvents = eventRepository.findAllByUser(user);
            events.addAll(userEvents);
        }

        return events;
    }
}
