package com.wad.firstmvc.repository;

import com.wad.firstmvc.domain.Category;
import com.wad.firstmvc.domain.ShoppingItem;
import com.wad.firstmvc.domain.User;
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
