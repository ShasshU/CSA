public class CollegeFightSong {
    public static void main(String[] args) {

        // \n for linebreak and \t for a tab space
        String USCFightSongP1 = "\tNow for a cheer they are here, triumphant!\n" + //
                "Here they come with banners flying,\n" + //
                "In stalwart step they're nighing,\n";

        // literal string
        String USCFightSongP2 = "\tWith shouts of vict'ry crying,\n" + //
                "We hurrah, hurrah, we greet you now,\n" + //
                "Hail!";

        // + operator for concatenation
        String USCFightSong = USCFightSongP1 + USCFightSongP2;

        // immutable string
        String str1 = new String(USCFightSongP1);

        // string created using the constructor
        str1 = str1.concat("With shouts of vict'ry crying,\n" + //
                "We hurrah, hurrah, we greet you now,\n" + //
                "Hail!0");

        // += operator to concatenate
        str1 += "With shouts of vict'ry crying,\n" + //
                "We hurrah, hurrah, we greet you now,\n" + //
                "Hail!0";

        // implicit conversion via concatenation and \ to add quotes
        int date = 1898;
        String message = "\"It was made in " + date + "\"";

        System.out.println(USCFightSong);
        System.out.println(message);

    }
}