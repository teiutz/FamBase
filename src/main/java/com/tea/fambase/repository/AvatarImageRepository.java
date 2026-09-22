package com.tea.fambase.repository;

import com.tea.fambase.domain.AvatarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarImageRepository extends JpaRepository<AvatarImage, Long> {
    AvatarImage save(AvatarImage avatarImage);

    List<AvatarImage> findAll();

    AvatarImage findAvatarImageById(Long id);
}
