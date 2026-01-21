import java.util.ArrayList;

class ListAlgorithm {
  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<String>();
    words.add("why");
    words.add("isn't");
    words.add("a");
    words.add("koala");
    words.add("considered");
    words.add("a");
    words.add("bear");
    words.add("?");
    System.out.println("Words: " + words);

    // call methods
    printPairs(words);
    socal(words);
    System.out.println("Socal" + words);
    moveRight(words);
    System.out.println("MoveRight: " + words);

  }

  // write methods
  public static void printPairs(ArrayList<String> arrayList) {
    for (int i = 0; i < arrayList.size(); i += 2) {
      System.out.println(arrayList.get(i) + " " + arrayList.get(i + 1));
    }

  }

  public static void socal(ArrayList<String> arrayList) {
    for (int i = 2; i <= arrayList.size(); i += 3) {
      arrayList.add(i, "like");
    }
  }

  public static void moveRight(ArrayList<String> arrayList) {
    String last = arrayList.remove(arrayList.size() - 1);
    arrayList.add(0, last);
  }
}
