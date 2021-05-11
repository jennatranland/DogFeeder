//author Jenna
package DogFeeder;

import java.util.Scanner;

public class dogFeeder extends dogFood {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(">Welcome to my dog feeding program."
                + "\n>You will choose the size of the dog to feed, but each have a max caloric intake you must meet without going over."
                + "\n>Type either Small, Medium, or Large to get to dog feeding!");
        boolean correctInput = false;
        String userInput = "";
        do {
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("small") && !userInput.equalsIgnoreCase("medium") && !userInput.equalsIgnoreCase("large")) {
                System.out.println(">ERROR: Invalid selection, please try again.");
            } else {
                correctInput = true;
            }
        } while (!correctInput);
        Dog dog = createDog(userInput);
        printMenu();
        System.out.println(">You have selected a " + dog.getDogSize() + " dog. Their name is " + dog.getDogName() + ", and their calorie limit is " + dog.getDogMaxCaloricIntake() + " calories.");

        feedDog(dog);
        printSelectedDogFood(dog);
    }
}
