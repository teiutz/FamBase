package com.tea.fambase.services;


import com.tea.fambase.domain.Family;
import com.tea.fambase.repository.EventRepository;
import com.tea.fambase.repository.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    private final FamilyRepository familyRepository;
    private final EventRepository eventRepository;

    public FamilyService(FamilyRepository familyRepository, EventRepository eventRepository) {
        this.familyRepository = familyRepository;
        this.eventRepository = eventRepository;
    }

    public void save(Family family) {
        familyRepository.save(family);
    }

}