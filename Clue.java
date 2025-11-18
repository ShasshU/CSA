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

    public boolean equals(Clue obj) {
        return murderer.equalsIgnoreCase(obj.murderer) && weapon.equalsIgnoreCase(obj.weapon)
                && room.equalsIgnoreCase(obj.room);
    }

    public void check(Clue obj) {

        if (murderer.equalsIgnoreCase(obj.murderer)) {
            System.out.println("Correct! " + murderer + " is the murderer");
        }
        if (weapon.equalsIgnoreCase(obj.weapon)) {
            System.out.println("Correct! " + weapon + " is the murder weapon");
        }
        if (room.equalsIgnoreCase(obj.room)) {
            System.out.println("Correct! " + room + " is the room the murder took place");
        }
    }

    public String toString() {
        return "Suspect: " + murderer + "\nWeapon: " + weapon + "\nRoom: " + room;
    }
}
