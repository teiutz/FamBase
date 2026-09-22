package com.tea.fambase.repository;

import com.tea.fambase.domain.Family;
import com.tea.fambase.domain.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User save(User user);

    boolean existsByUsername(String username);

    User findByUsername(String username);

    List<User> findAll();

    List<User> findAllByFamily(Family family);


}
