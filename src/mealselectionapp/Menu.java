/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mealselectionapp;
import java.util.List;
/**
 *
 * @author steve
 */
public interface Menu {
    void addMeal(Meal meal);
    void removeMeal(Meal meal);
    Meal getMealById(int mealId);
    List<Meal> getAllMeals();
}

