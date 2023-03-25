package mealselectionapp;

/**
 *
 * @author steve
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author steve
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MealSelectionApp extends JFrame implements ActionListener {
    private JTextField mealTypeField;
    private JTextField eatenFoodsField;
    private JTextArea resultsArea;
    private MealSelectionSystem mealSelectionSystem;

    public MealSelectionApp(MealSelectionSystem mealSelectionSystem) {
        this.mealSelectionSystem = mealSelectionSystem;

        setTitle("Meal Selection System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel mealTypeLabel = new JLabel("Meal type:");
        mealTypeField = new JTextField(20);

        JLabel eatenFoodsLabel = new JLabel("Foods eaten:");
        eatenFoodsField = new JTextField(20);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        setEnabled(true);
        setVisible(true);

        resultsArea = new JTextArea(10, 50);
  
        resultsArea.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(mealTypeLabel);
        inputPanel.add(mealTypeField);
        inputPanel.add(eatenFoodsLabel);
        inputPanel.add(eatenFoodsField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        JPanel resultsPanel = new JPanel();
        resultsPanel.add(new JScrollPane(resultsArea));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(resultsPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Submit")) {
        String mealType = mealTypeField.getText();
        String[] eatenFoods = eatenFoodsField.getText().split(",");
        List<String> eatenFoodsList = new ArrayList<>();
        
        for (String eatenFood : eatenFoods) {
            eatenFoodsList.add(eatenFood.trim());
        }

        List<String> suggestedFoods = mealSelectionSystem.suggestFoods(mealType, eatenFoodsList);

        resultsArea.setText("");
        for (String suggestedFood : suggestedFoods) {
            resultsArea.append(suggestedFood + "\n");
        }
    }
}

    public static void main(String[] args) {
        MenuImpl menu = new MenuImpl();
      menu.addMeal(1, "Scrambled Eggs", "Breakfast", List.of("Eggs", "Milk", "Butter", "Salt"), 5.99);
      menu.addMeal(2, "Pancakes", "Breakfast", List.of("Flour", "Sugar", "Baking Powder", "Egg", "Milk", "Butter"), 7.99);
      menu.addMeal(3, "Bacon and Eggs", "Breakfast", List.of("Eggs", "Bacon", "Salt", "Pepper"), 6.99);

      menu.addMeal(4, "Chicken Caesar Salad", "Lunch", List.of("Lettuce", "Chicken", "Croutons", "Parmesan Cheese", "Caesar Dressing"), 10.99);
      menu.addMeal(5, "Greek Salad", "Lunch", List.of("Lettuce", "Tomatoes", "Cucumbers", "Onions", "Feta Cheese", "Olives", "Greek Dressing"), 8.99);
      menu.addMeal(6, "Pasta with Tomato Sauce", "Lunch", List.of("Pasta", "Tomato Sauce", "Garlic", "Onion", "Olive Oil"), 9.99);

      menu.addMeal(7, "Grilled Chicken", "Dinner", List.of("Chicken","Olive Oil", "Salt", "Pepper"), 12.99);
      menu.addMeal(8, "Steak and Potatoes", "Dinner", List.of("Steak", "Potatoes", "Garlic", "Rosemary", "Butter"), 17.99);
      menu.addMeal(9, "Salmon with Lemon Butter Sauce", "Dinner", List.of("Salmon", "Lemon", "Butter", "Garlic", "White Wine"), 19.99);

    MealSelectionSystem mealSelectionSystem = new MealSelectionSystem(menu);

    MealSelectionApp app = new MealSelectionApp(mealSelectionSystem);
    app.setVisible(true);
}
}


