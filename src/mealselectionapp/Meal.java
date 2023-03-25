/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mealselectionapp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author steve
 */
public class Meal {
    private int id;
    private String name;
    private String type;
    private List<String> ingredients;
    private double price;

   public Meal(int id, String name, String type, List<String> ingredients, double price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.ingredients = ingredients;
    this.price = price;
}


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
        public int getId() {
        return id;
        
        }

    public List<String> getIngredients() {
        return ingredients;
    }
public double getPrice() {
    return price;
}

    public boolean containsIngredients(List<String> eatenFoods) {
    for (String food : eatenFoods) {
        if (!ingredients.contains(food)) {
            return false;
        }
    }
    return true;
}

}
