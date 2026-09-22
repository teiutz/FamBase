package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    Family save(Family family);

}
