public class DigiPetMain {
    public static void main(String[] args) {

        DigiPet Hangry = new DigiPet("Hangry", "cat");
        DigiPet Fido = new DigiPet("Fido", "dog");

        System.out.println(Hangry.toString());
        System.out.println();
        System.out.println(Fido.toString());
        System.out.println();

        Hangry.speak();
        Fido.speak();

        Hangry.play();
        Fido.play();

        Hangry.feed();
        Fido.feed();

        Hangry.sleep();
        Fido.sleep();

        System.out.println();

        System.out.println(Hangry.toString());
        System.out.println();
        System.out.println(Fido.toString());
    }
}