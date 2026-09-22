package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.Event;
import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    Event save(Event event);
    List<Event> findByType(String type);
    List<Event> findAll();

    List<Event> findAllByUser(User user);



}
