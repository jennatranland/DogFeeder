package DogFeeder;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;
import java.util.Scanner;

public class dogFood extends Dog {

    private static final Scanner scanner = new Scanner(System.in);
    public static int caloriesRemaining = 0;
    private static int totalCalories = 0;
    public static boolean foodFound = false;
    public static List<Pair<String, Integer>> selectedFoods = new ArrayList<>();
    public static List<Pair<String, Integer>> foodList = new ArrayList<>();

    public static void feedDog(Dog dog) {

        caloriesRemaining = dog.getDogMaxCaloricIntake();
        if (foodList.isEmpty()) {
            foodList = createFoodList();
        }

        System.out.println(">Type in any of the foods on the menu to feed your dog! \n>Type 'Confirm' at any time when you are done feeding your dog.");

        do {
            String selectedFood = scanner.nextLine();
            foodFound = false;
            if (selectedFood.equalsIgnoreCase("Confirm")) {
                break;
            }
            foodList.forEach(food -> {
                if (selectedFood.equalsIgnoreCase(food.getValue0())) {
                    foodFound = true;
                    if (caloriesRemaining < food.getValue1()) {
                        System.out.println(">ERROR: " + food.getValue0() + " is " + food.getValue1() + " calories. Our current max calories are " + caloriesRemaining
                                + " calories.\n>Please select a lower calorie food or type 'Confirm' to finish.");
                    } else {
                        selectedFoods.add(food);
                        caloriesRemaining -= food.getValue1();
                        System.out.println(">" + food.getValue0() + " has been added to their meal plan. There are " + caloriesRemaining + " calories remaining at most to feed the dog.");
                        System.out.println(">Type in any of the foods on the menu to feed your dog! \n>Type 'Confirm' at any time when you are done feeding your dog.");
                    }
                }
            });
            if (!foodFound) {
                System.out.println(">ERROR: Your selection '" + selectedFood + "' was not found on the list. \n>Please try again.");
            }
        } while (caloriesRemaining != 0);
    }

    public static void printSelectedDogFood(Dog dog) {

        System.out.println(">Here is the list of food we have fed to " + dog.getDogName() + ": ");

        selectedFoods.forEach(food -> {
            String string1 = ">Food: " + food.getValue0();
            String string2 = "Calories: " + food.getValue1();
            System.out.format("%-30s %-30s %n", string1, string2);
            totalCalories += food.getValue1();
        });

        if (dog.getDogMaxCaloricIntake() == caloriesRemaining) {
            System.out.println(">You did not feed anything to " + dog.getDogName() + ", you are a terrible dog owner!");
        } else {
            System.out.println(">Total Calories: " + totalCalories);
        }
    }

    public static void printMenu() {

        foodList = createFoodList();
        foodList.forEach(food -> {
            String string1 = ">Food: " + food.getValue0();
            String string2 = "Calories: " + food.getValue1();
            System.out.format("%-30s %-30s %n", string1, string2);
        });
    }

    public static List createFoodList() {
        foodList.add(Pair.with("Ice Cream", 137));
        foodList.add(Pair.with("Gold Fish Crackers", 140));
        foodList.add(Pair.with("Cooked Chicken Breast", 284));
        foodList.add(Pair.with("French Fries", 365));
        foodList.add(Pair.with("Five Ritz Crackers", 80));
        foodList.add(Pair.with("Cheeseburger", 381));
        foodList.add(Pair.with("Tofu", 94));
        foodList.add(Pair.with("6-inch Personal Pizza", 800));
        foodList.add(Pair.with("Slice of Cake", 350));
        foodList.add(Pair.with("Peanut Butter", 188));
        foodList.add(Pair.with("Ham and Cheese Sandwich", 352));
        foodList.add(Pair.with("White Rice", 206));
        foodList.add(Pair.with("Banana Slices", 105));
        foodList.add(Pair.with("Hard Boiled Egg", 78));
        foodList.add(Pair.with("Stacked Pancakes", 525));
        foodList.add(Pair.with("Greek Yogurt", 100));
        foodList.add(Pair.with("Blueberries", 85));
        foodList.add(Pair.with("Carrot Slices", 25));
        foodList.add(Pair.with("Cucumber Slices", 10));
        foodList.add(Pair.with("Ramen Bowl", 600));
        foodList.add(Pair.with("Hoagie", 456));
        foodList.add(Pair.with("Pho Bowl", 450));
        foodList.add(Pair.with("Gazpacho", 70));
        foodList.add(Pair.with("Baked Potato", 300));
        foodList.add(Pair.with("Cookie", 138));
        foodList.add(Pair.with("Sausage Link", 400));
        foodList.add(Pair.with("Sugary Cereal", 150));
        foodList.add(Pair.with("Steamed Broccoli", 50));
        foodList.add(Pair.with("Whipped Cream", 400));
        foodList.add(Pair.with("Combination Fried Rice", 1000));
        foodList.add(Pair.with("Applesauce", 166));
        foodList.add(Pair.with("Mac and Cheese", 310));
        foodList.add(Pair.with("Banh Mi", 750));
        foodList.add(Pair.with("Spring Rolls", 300));
        foodList.add(Pair.with("Japanese Curry", 440));
        foodList.add(Pair.with("Shrimp", 99));
        foodList.add(Pair.with("Fried Chicken Bucket", 1200));
        foodList.add(Pair.with("Oatmeal", 158));
        foodList.add(Pair.with("Rice Congee", 100));
        foodList.add(Pair.with("Meat Lover's Omelette", 760));
        foodList.add(Pair.with("Nachos Supreme", 479));
        foodList.add(Pair.with("10-pc Chicken Nuggets", 420));

        return foodList;
    }
}
