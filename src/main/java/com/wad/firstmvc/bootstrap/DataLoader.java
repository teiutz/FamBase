package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.*;
import com.wad.firstmvc.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final ShoppingItemRepository shoppingItemRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final FamilyRepository familyRepository;
    private final AvatarImageRepository avatarImageRepository;
    private final PasswordEncoder bcrypt = new BCryptPasswordEncoder();

    public DataLoader(TaskRepository taskRepository, ShoppingItemRepository shoppingItemRepository, EventRepository eventRepository, UserRepository userRepository, FamilyRepository familyRepository, AvatarImageRepository avatarImageRepository) {
        this.taskRepository = taskRepository;
        this.shoppingItemRepository = shoppingItemRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.familyRepository = familyRepository;
        this.avatarImageRepository = avatarImageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        AvatarImage avatarImage1 = new AvatarImage("https://i.ibb.co/rGj6pjhz/1.png");
        AvatarImage avatarImage2 = new AvatarImage("https://i.ibb.co/PsgRrctR/2.png");
        AvatarImage avatarImage3 = new AvatarImage("https://i.ibb.co/7JpJ0J2S/3.png");

        avatarImageRepository.saveAll(List.of(avatarImage1, avatarImage2, avatarImage3));

        Family family1 = new Family("Tatoiu");
        familyRepository.save(family1);

        Family family2 = new Family("Bianca");
        familyRepository.save(family2);

        User admin = new User(1L, "tea", bcrypt.encode("tea"), "Female", Role.ROLE_ADMIN, family1, avatarImage1);
        User user2 = new User(2L, "mirela", bcrypt.encode("mirela"), "Female", Role.ROLE_USER, family1, avatarImage2);
        User user3 = new User(3L, "tudor", bcrypt.encode("tudor"), "Male", Role.ROLE_USER, family1, avatarImage3);

        User user4 = new User(4L, "bianca", bcrypt.encode("bianca"), "Female", Role.ROLE_ADMIN, family2, avatarImage1);
        userRepository.saveAll(List.of(admin, user2, user3, user4));

        Task task1 = new Task("Wash Dishes", "", LocalDate.of(2026, 9, 30), "High priority", TaskType.Errands, admin);

        taskRepository.saveAll(List.of(task1));

    }
}
