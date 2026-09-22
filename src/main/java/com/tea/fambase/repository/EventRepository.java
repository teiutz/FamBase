package com.tea.fambase.repository;

import com.tea.fambase.domain.Event;
import com.tea.fambase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    Event save(Event event);
    List<Event> findByType(String type);
    List<Event> findAll();

    List<Event> findAllByUser(User user);



}
