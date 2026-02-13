import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetSimulator {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("Pet Simulator Program");
        System.out.println("Started: " + now.format(formatter));
        System.out.println();

        Pet[] pets = new Pet[10];

        pets[0] = new Pet("William", Pet.DOG);
        pets[1] = new Pet("Shawn", Pet.DOG);
        pets[2] = new Pet("Vaughn", Pet.CAT);
        pets[3] = new Pet("Fareed", Pet.CAT);

        // create an array that can hold up to 10 pets (does not require looping)
        // adopt (create and name) four pets, two cats, two dogs (does not require
        // looping)
        // first things first, feed your pets
        for (Pet feedPets : pets) {
            if (feedPets != null) {
                feedPets.feed();
            }
        }
        // next, make yourself the owner of all of your new pets
        for (Pet Owner : pets) {
            if (Owner != null) {
                Owner.setOwner("Shassh");
            }
        }

        // your dogs make some noise, take them for a walk
        for (Pet noisy : pets) {
            if (noisy != null) {
                if (noisy.getType() == 2) {
                    noisy.makeNoise();
                    noisy.walk();
                }
            }
        }
        // when you get back, your cats make some noise
        for (Pet noisyCat : pets) {
            if (noisyCat != null) {
                if (noisyCat.getType() == 1) {
                    noisyCat.makeNoise();
                }
            }
        }

        // give all of your pets a treat
        for (Pet treat : pets) {
            if (treat != null) {
                treat.giveTreat();
            }
        }
        // groom your cats
        for (Pet groom : pets) {
            if (groom != null) {
                if (groom.getType() == 1) {
                    groom.groom();
                }
            }
        }
        // grooming is done, play with all pets
        for (Pet play : pets) {
            if (play != null) {
                play.play();
            }
        }
        // whew, that was tiring, all pets nap and get fed
        for (Pet finish : pets) {
            if (finish != null) {
                finish.sleep();
                finish.feed();
            }
        }

        System.out.println("--- MY PETS ---");
        for (Pet print : pets) {
            if (print != null) {
                System.out.println(print);
            }
        }
        // show the state of all of your pets
        // You decide to get a couple of pets for your friend (does not require looping)
        pets[4] = new Pet("Anthony", Pet.DOG);
        pets[5] = new Pet("Rameses", Pet.DOG);

        // set the owner of the new pets to your friends name
        pets[4].setOwner("Eugene");
        pets[5].setOwner("Eugene");

        System.out.println("--- MY PETS ---");

        // show the state of all of your pets
        for (Pet all : pets) {
            if (all != null) {
                System.out.println(all);
            }
        }
        // --- Pet Class ---
        // Copy the code below for your Per class
    }

}