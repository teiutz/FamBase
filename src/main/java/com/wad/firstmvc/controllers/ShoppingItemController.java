package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Category;
import com.wad.firstmvc.domain.ShoppingItem;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.services.ShoppingItemService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/shoppingItems")
public class ShoppingItemController {
    private final ShoppingItemService shoppingItemService;

    public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }

    @GetMapping
    public String viewShoppingItems(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("shoppingItems", shoppingItemService.findByUserFamily(currentUser.getFamily()));
        return "general/all";
    }

    @GetMapping("/new")
    public String showAddShoppingItemForm(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("shoppingItem", new ShoppingItem());
        return "shopping-items/addshoppingItems";
    }

    @PostMapping("/new")
    public String addShoppingItem(ShoppingItem shoppingItem, @AuthenticationPrincipal User currentUser) {
        if (shoppingItem.getId() == null) shoppingItem.setId(new Random().nextLong());
        shoppingItem.setUser(currentUser);
        shoppingItemService.save(shoppingItem);
        return "redirect:/all";
    }


    @GetMapping("/delete")
    public String deleteShoppingItem(@RequestParam("id") String id, Model model) {
        ShoppingItem shoppingItem = shoppingItemService.findById(Long.parseLong(id));
        shoppingItemService.delete(shoppingItem);
        return "redirect:/all";
    }

    @GetMapping("/allshoppingItems")
    public String showEventsPage(Model model) {
        model.addAttribute("shoppingItems", shoppingItemService.findAll());
        return "shopping-items/shopping-list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        ShoppingItem shoppingItem = shoppingItemService.findById(id);
        model.addAttribute("shoppingItem", shoppingItem);
        return "shopping-items/updateshoppingitems";
    }

    @PostMapping("/update")
    public String updateShoppingItem(@ModelAttribute ShoppingItem shoppingItem) {
        shoppingItemService.update(shoppingItem);
        return "redirect:/all";
    }

    @GetMapping("/grouped")
    public String showGroupedListItems(Model model) {
        model.addAttribute("green", shoppingItemService.findByCategory(Category.FruitsNVeggies));
        model.addAttribute("dairy", shoppingItemService.findByCategory(Category.DairyNProtein));
        model.addAttribute("pantry", shoppingItemService.findByCategory(Category.PantryNDryGoods));
        model.addAttribute("household", shoppingItemService.findByCategory(Category.HouseholdNMiscellaneous));
        return "shopping-items/groupedShoppingItems";
    }
}