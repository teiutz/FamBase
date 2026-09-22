package com.tea.fambase.services;

import com.tea.fambase.domain.Category;
import com.tea.fambase.domain.Family;
import com.tea.fambase.domain.ShoppingItem;
import com.tea.fambase.domain.User;
import com.tea.fambase.repository.ShoppingItemRepository;
import com.tea.fambase.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingItemService {
    private final ShoppingItemRepository shoppingItemRepository;
    private final UserRepository userRepository;

    public ShoppingItemService(ShoppingItemRepository shoppingItemRepository, UserRepository userRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
        this.userRepository = userRepository;
    }

    public List<ShoppingItem> findAll() {
        return shoppingItemRepository.findAll();
    }

    public ShoppingItem save(ShoppingItem shoppingItem) {
        return shoppingItemRepository.save(shoppingItem);
    }

    public List<ShoppingItem> findByImportance(String importance) {
        return shoppingItemRepository.findByImportance(importance);
    }

    public List<ShoppingItem> findByCategory(Category category) {
        return shoppingItemRepository.findByCategory(category);
    }

    public ShoppingItem findById(Long id) {
        Optional<ShoppingItem> shoppingItem = shoppingItemRepository.findById(id);
        return shoppingItem.orElse(null);
    }

    public void delete(ShoppingItem shoppingItem) {
        shoppingItemRepository.delete(shoppingItem);
    }

    public void update(ShoppingItem shoppingItem) {
        shoppingItemRepository.save(shoppingItem);
    }

    public List<ShoppingItem> findByUserFamily(Family family) {
        List<ShoppingItem> shoppingItems = new ArrayList<>();

        for (User user : userRepository.findAllByFamily(family)) {
            List<ShoppingItem> userShoppingItems = shoppingItemRepository.findAllByUser(user);
            shoppingItems.addAll(userShoppingItems);
        }
        return shoppingItems;
    }
}
