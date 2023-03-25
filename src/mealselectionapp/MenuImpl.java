/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mealselectionapp;
import mealselectionapp.MealType;
/**
 *
 * @author steve
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

public class MenuImpl implements Menu {
    
    private List<Meal> meals;

    public MenuImpl() {
        this.meals = new ArrayList<>();
    }
    
public void addMeal(int id, String name, String type, List<String> ingredients, double price) {
    Meal meal = new Meal(id, name, type, ingredients, price);
    meals.add(meal);
}


    @Override
    public void removeMeal(Meal meal) {
        meals.remove(meal);
    }

    @Override
    public List<Meal> getAllMeals() {
        return Collections.unmodifiableList(meals);
    }


   public List<Meal> getMealsByType(MealType type) {
    return meals.stream()
            .filter(meal -> meal.getType().equals(type))
            .collect(Collectors.toList());
   

}


    public List<Meal> getMealsByPriceRange(double minPrice, double maxPrice) {
        return meals.stream()
                .filter(meal -> meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }


    public Optional<Meal> getMealByName(String name) {
        return meals.stream()
                .filter(meal -> meal.getName().equalsIgnoreCase(name))
                .findFirst();
    }
    public Meal getMealById(int id) {
    for (Meal meal : meals) {
        if (meal.getId() == id) {
            return meal;
        }
    }
    return null;
}

    @Override
    public void addMeal(Meal meal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

