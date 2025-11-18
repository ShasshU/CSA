import java.util.Scanner;

public class MainClue {
	public static void main(String[] args) {
		// generating a random Suspect - Weapon - Room solution
		Secret random = new Secret();
		String finalMurderer = random.secretMurderer();
		String finalWeapon = random.secretWeapon();
		String finalRoom = random.secretRoom();

		// Creating Clue Object with solution
		Clue solution = new Clue(finalMurderer, finalWeapon, finalRoom);
		// this line is for testing purposes only
		System.out.println(solution);

		// printing options for user to choose from
		System.out.println("Welcome to Clue! Choose one from each category.\n");
		System.out.println("Suspect \tWeapon \t\tRoom");
		System.out.println("Miss Scarlett \tCandlestick \tKitchen");
		System.out.println("Mr. Green \tKnife \t\tBallroom");
		System.out.println("Colonel Mustard Lead Pipe \tConservatory");
		System.out.println("Professor Plum \tRevolver \tBilliard Room");
		System.out.println("Mrs. Peacock \tRope \t\tLibrary");
		System.out.println("Mrs. White \tWrench \t\tStudy");
		System.out.println("\t\t\t\tHall");
		System.out.println("\t\t\t\tLounge");
		System.out.println("\t\t\t\tDining Room");
		System.out.println();

		// Asking user for final guess
		Scanner sc = new Scanner(System.in);
		System.out.println("Make your final accusation, separated by the enter key:");
		String userSuspect = sc.nextLine();
		String userWeapon = sc.nextLine();
		String userRoom = sc.nextLine();

		Clue guess = new Clue(userSuspect, userWeapon, userRoom);
		if (guess.equals(solution)) {
			System.out.println(
					"Congratulations! \nIt was " + userSuspect + " with the " + userWeapon + " in the " + userRoom);
		} else {
			guess.check(solution);
		}
	}
}