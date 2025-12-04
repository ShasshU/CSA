public class Clue {
    // attributes
    String murderer;
    String weapon;
    String room;

    // constructor
    public Clue(String _murderer, String _weapon, String _room) {
        murderer = _murderer;
        weapon = _weapon;
        room = _room;
    }

    // checks if this Clue equals another Clue object (case insensitive)
    public boolean equals(Clue obj) {
        return murderer.equalsIgnoreCase(obj.murderer) && weapon.equalsIgnoreCase(obj.weapon)
                && room.equalsIgnoreCase(obj.room);
    }

    // checks which parts of the guess are correct and prints feedback
    public void check(Clue obj) {

        if (murderer.equalsIgnoreCase(obj.murderer)) {
            System.out.println("You have the correct murderer.");
        }
        if (weapon.equalsIgnoreCase(obj.weapon)) {
            System.out.println("You have the correct weapon.");
        }
        if (room.equalsIgnoreCase(obj.room)) {
            System.out.println("You have the correct room.");
        }
    }

    // returns a string representation of the Clue object
    public String toString() {
        return "Suspect: " + murderer + "\nWeapon: " + weapon + "\nRoom: " + room;
    }
}
