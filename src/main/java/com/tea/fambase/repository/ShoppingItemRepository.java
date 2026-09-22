package com.tea.fambase.repository;

import com.tea.fambase.domain.Category;
import com.tea.fambase.domain.ShoppingItem;
import com.tea.fambase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

    ShoppingItem save(ShoppingItem shoppingItem);

    List<ShoppingItem> findByImportance(String importance);

    List<ShoppingItem> findByCategory(Category category);

    List<ShoppingItem> findAllByUser(User user);


}
