public class DigiPet {

    String name;
    String animal;
    int food;
    int energy;
    int happy;

    public DigiPet(String name, String animal) {
        this.name = name;
        this.animal = animal;
        this.food = 20;
        this.energy = 20;
        this.happy = 20;
    }

    public void speak() {
        if (this.animal.equalsIgnoreCase("dog")) {
            System.out.println("Bark! Bark!");
        } else if (this.animal.equalsIgnoreCase("cat")) {
            System.out.println("Purr! Purr!");
        } else {
            System.out.println("I don't know what sound that animal makes.");
        }
    }

    public void play() {
        System.out.println("Yay! Let's play!");
        this.happy += 10;
        this.food -= 10;
        this.energy -= 10;
    }

    public void feed() {
        if (this.food > 15) {
            System.out.println(name + " is not hungry!");
            this.happy -= 10;
        } else {
            System.out.println("Yay! Food!");
            this.food += 10;
            this.energy += 10;
        }
    }

    public void sleep() {
        if (this.energy > 20) {
            System.out.println(name + " is not sleepy!");
            this.happy -= 10;
        } else {
            System.out.println("zzzzzzzzzzzzzzz!");
            this.happy += 15;
            this.energy = 50;
        }
    }

    public String toString() {
        return name + " the " + animal +
                "\nHunger: " + food +
                "\nEnergy: " + energy +
                "\nHappy: " + happy;
    }
}