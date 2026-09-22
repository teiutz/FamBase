package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.AvatarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarImageRepository extends JpaRepository<AvatarImage, Long> {
    AvatarImage save(AvatarImage avatarImage);

    List<AvatarImage> findAll();

    AvatarImage findAvatarImageById(Long id);
}
