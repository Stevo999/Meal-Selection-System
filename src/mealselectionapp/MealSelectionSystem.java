/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mealselectionapp;
import java.util.ArrayList;
import java.util.List;
import mealselectionapp.MealType;

/**
 *
 * @author steve
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author steve
 */
import java.util.ArrayList;
import java.util.List;

public class MealSelectionSystem {
    private MenuImpl menu;

    public MealSelectionSystem(MenuImpl menu) {
        this.menu = menu;
    }
    public List<String> suggestFoods(String mealType, List<String> eatenFoods) {
            MealType type;
            List<String> suggestedFoods = new ArrayList<>();
switch (mealType) {
    case "Breakfast":
        type = MealType.BREAKFAST;
        break;
    case "Lunch":
        type = MealType.LUNCH;
        break;
    case "Dinner":
        type = MealType.DINNER;
        break;
    default:
        type = null;
}
if (type == null) {
    return suggestedFoods;
}
List<Meal> meals = menu.getMealsByType(type);


        for (Meal meal : meals) {
            if (meal.containsIngredients(eatenFoods)) {
                continue;
            }

            for (String ingredient : meal.getIngredients()) {
                if (!eatenFoods.contains(ingredient)) {
                    suggestedFoods.add(meal.getName());
                    break;
                }
            }
        }

        return suggestedFoods;
    }
}