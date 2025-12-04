/*=============================================================================
 |   Assignment:  Program #5: Project 3.7.1 Clue 
 |       Author:  Shassh Umamaheswaran
 |      Partner:  NA
 |
 |  Course Name:  Computer Science A
 |   Instructor:  John Smith
 |     Due Date:  Dec 5, 2025 11:59pm
 |
 |  Description:  This program simulates the  board game Clue.
 |                It randomly generates a murder mystery scenario with a
 |                suspect, weapon, and room. The user makes guesses until
 |                they correctly identify all three elements. The program
 |                provides feedback on which parts of the guess are correct.
 |
 |     Language:  Java version 8
 | Ex. Packages:  java.util.Scanner
 |
 | Deficiencies:  NA
 *===========================================================================*/

import java.util.Scanner;

public class MainClue {

	// main method to run the Clue game simulation
	public static void main(String[] args) {
		// generating a random suspect, weapon, room solution
		Secret random = new Secret();
		String finalMurderer = random.secretMurderer();
		String finalWeapon = random.secretWeapon();
		String finalRoom = random.secretRoom();

		// creating Clue Object with solution
		Clue solution = new Clue(finalMurderer, finalWeapon, finalRoom);
		// this line is for testing purposes only
		System.out.println(solution);

		// printing options for user to choose from
		System.out.println("Welcome to Clue! Choose one from each category.\n");
		System.out.println("Suspect \tWeapon \t\tRoom");
		System.out.println("Miss Scarlett \tCandlestick \tKitchen");
		System.out.println("Mr. Green \tKnife \t\tBallroom");
		System.out.println("Colonel Mustard \tLead Pipe \tConservatory");
		System.out.println("Professor Plum \tRevolver \tBilliard Room");
		System.out.println("Mrs. Peacock \tRope \t\tLibrary");
		System.out.println("Mrs. White \tWrench \t\tStudy");
		System.out.println("\t\t\t\tHall");
		System.out.println("\t\t\t\tLounge");
		System.out.println("\t\t\t\tDining Room");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		boolean solved = false;

		// extra credit: loop to allow multiple attempts
		while (!solved) {
			// asks user for guess
			System.out.println("Make your final accusation, separated by the enter key:");
			String userSuspect = sc.nextLine();
			String userWeapon = sc.nextLine();
			String userRoom = sc.nextLine();

			Clue guess = new Clue(userSuspect, userWeapon, userRoom);
			if (guess.equals(solution)) {
				System.out.println("\nCongratulations!");
				System.out.println("It was " + finalMurderer + " with the " + finalWeapon + " in the " + finalRoom);
				solved = true;
			} else {
				System.out.println();
				guess.check(solution);
				System.out.println("\nTry again!\n");
			}
		}

		sc.close();
	}
}