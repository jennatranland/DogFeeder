//author Jenna
package DogFeeder;

public class Dog {

    private static final int maxCaloricIntake_SmallDog = 320;
    private static final int maxCaloricIntake_MediumDog = 1200;
    private static final int maxCaloricIntake_LargeDog = 2100;
    private final String dogName;
    private final String dogSize;
    private final int maxCaloricIntake;
    private static final String dogName_SmallDog = "King";
    private static final String dogName_MediumDog = "Sunny";
    private static final String dogName_LargeDog = "Missu";

    public Dog(){
        
    this.dogName = "DEFAULT";
    this.dogSize = "DEFAULT";
    this.maxCaloricIntake = 0;
    
    }
    
    public Dog(String dogName, String dogSize, int maxCaloricIntake) {

        this.dogName = dogName;
        this.dogSize = dogSize;
        this.maxCaloricIntake = maxCaloricIntake;

    }

    public static Dog createDog(String dogSize) {
        if (dogSize.equalsIgnoreCase("small")) {
            return new Dog(dogName_SmallDog, "Small", maxCaloricIntake_SmallDog);
        } else if (dogSize.equalsIgnoreCase("medium")) {
            return new Dog(dogName_MediumDog, "Medium", maxCaloricIntake_MediumDog);
        } else if (dogSize.equalsIgnoreCase("large")) {
            return new Dog(dogName_LargeDog, "Large", maxCaloricIntake_LargeDog);
        } else {
            return new Dog();
        }
    }
    
    public String getDogName(){
        return dogName;
    }
    public String getDogSize(){
        return dogSize;
    }
    public int getDogMaxCaloricIntake(){
        return maxCaloricIntake;
    }
}
