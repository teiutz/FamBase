package com.wad.firstmvc.services;


import com.wad.firstmvc.domain.Family;
import com.wad.firstmvc.repository.EventRepository;
import com.wad.firstmvc.repository.FamilyRepository;
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