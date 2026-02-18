/*=============================================================================
 |   Assignment:  Project Array & ArrayList Library Index
 |       Author:  Shassh Umamaheswaran
 |      Partner:  None
 |
 |  Course Name:  AP Computer Science A
 |   Instructor:  Jonathan Virak
 |     Due Date:  February 18, 2026 3:30pm
 |
 |  Description:  This program manages a library index of books across three
 |                categories: Economics, Political Science, and History. It
 |                stores a library array of Book objects, then prints all
 |                Out of Stock books and all books published before 1900.
 |                The user's 10 class textbook ISBNs are stored in an
 |                ArrayList and queried against the library array. All
 |                results are sorted by category and alphabetically by title
 |                using a bubble sort algorithm. The program uses the Java
 |                Time API to display the current date and time
 |
 |     Language:  Java 8
 | Ex. Packages:  java.util.ArrayList, java.time.LocalDateTime,
 |                java.time.format.DateTimeFormatter
 |
 | Deficiencies:  NA
 *===========================================================================*/

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LibraryIndex {
    public static void main(String[] args) {
        // display program name and current date/time using Java Time API
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("Library Index Program");
        System.out.println("Started: " + now.format(formatter));

        class Book {
            String title;
            String author;
            int year;
            String isbn;
            String genre;
            String availability;

            public Book(String title, String author, int year, String isbn, String genre, String availability) {
                this.title = title;
                this.author = author;
                this.year = year;
                this.isbn = isbn;
                this.genre = genre;
                this.availability = availability;
            }

        }
        Book[] books = {
                new Book("The History of the Peloponnesian War", "Thucydides", 2003, "9780140449266", "History",
                        "In Stock"),
                new Book("The Rise and Fall of the Third Reich", "William L. Shirer", 1990, "9780679720201", "History",
                        "Out of Stock"),
                new Book("Guns, Germs, and Steel", "Jared Diamond", 1997, "9780307387899", "History", "In Stock"),
                new Book("The Rise and Fall of the Great Powers", "Paul Kennedy", 1987, "9780679404736", "History",
                        "Out of Stock"),
                new Book("The Cold War: A New History", "John Lewis Gaddis", 2005, "9780143039433", "History",
                        "In Stock"),
                new Book("Postwar: A History of Europe Since 1945", "Tony Judt", 2005, "9781400032716", "History",
                        "In Stock"),
                new Book("The Roman Revolution", "Ronald Syme", 1939, "9780192805511", "History", "Out of Stock"),
                new Book("A People's History of the United States", "Howard Zinn", 1980, "9780375758786", "History",
                        "In Stock"),
                new Book("The Lessons of History", "Will Durant & Ariel Durant", 1968, "9780142002100", "History",
                        "In Stock"),
                new Book("The Wright Brothers", "David McCullough", 2015, "9780670020898", "History", "Out of Stock"),
                new Book("SPQR: A History of Ancient Rome", "Mary Beard", 2015, "9780871404237", "History", "In Stock"),
                new Book("The Silk Roads", "Peter Frankopan", 2015, "9781101912379", "History", "Out of Stock"),
                new Book("1776", "David McCullough", 2005, "9780743226714", "History", "In Stock"),
                new Book("Team of Rivals", "Doris Kearns Goodwin", 2005, "9780684824901", "History", "In Stock"),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947, "9780553296983", "History", "Out of Stock"),
                new Book("The Prince", "Niccolò Machiavelli", 1532, "9780226731561", "Political Science", "In Stock"),
                new Book("The Communist Manifesto", "Karl Marx & Friedrich Engels", 1848, "9780140449334",
                        "Political Science", "Out of Stock"),
                new Book("The Origins of Political Order", "Francis Fukuyama", 2011, "9780465093339",
                        "Political Science", "In Stock"),
                new Book("Democracy in America", "Alexis de Tocqueville", 1835, "9780307274939", "Political Science",
                        "Out of Stock"),
                new Book("Political Order and Political Decay", "Francis Fukuyama", 2014, "9780691156044",
                        "Political Science", "In Stock"),
                new Book("Leviathan", "Thomas Hobbes", 1651, "9780140449211", "Political Science", "In Stock"),
                new Book("On Tyranny", "Timothy Snyder", 2017, "9780465007855", "Political Science", "Out of Stock"),
                new Book("The Federalist Papers", "Alexander Hamilton, James Madison, John Jay", 1788, "9780140449273",
                        "Political Science", "In Stock"),
                new Book("The Road to Serfdom", "Friedrich Hayek", 1944, "9780226458116", "Political Science",
                        "In Stock"),
                new Book("The Clash of Civilizations and the Remaking of World Order", "Samuel P. Huntington", 1996,
                        "9780307387905", "Political Science", "Out of Stock"),
                new Book("The Open Society and Its Enemies", "Karl Popper", 1945, "9780691158130", "Political Science",
                        "In Stock"),
                new Book("Imagined Communities", "Benedict Anderson", 1983, "9781784786755", "Political Science",
                        "Out of Stock"),
                new Book("The End of History and the Last Man", "Francis Fukuyama", 1992, "9780029109755",
                        "Political Science", "In Stock"),
                new Book("Justice: What's the Right Thing to Do?", "Michael J. Sandel", 2009, "9780374532509",
                        "Political Science", "In Stock"),
                new Book("Why Nations Fail", "Daron Acemoglu & James A. Robinson", 2012, "9780307719218",
                        "Political Science", "Out of Stock"),
                new Book("The Wealth of Nations", "Adam Smith", 1776, "9780140449280", "Economics", "In Stock"),
                new Book("Capital in the Twenty-First Century", "Thomas Piketty", 2013, "9780393337642", "Economics",
                        "Out of Stock"),
                new Book("Capitalism and Freedom", "Milton Friedman", 1962, "9780465060737", "Economics", "In Stock"),
                new Book("The General Theory of Employment, Interest, and Money", "John Maynard Keynes", 1936,
                        "9780140449150", "Economics", "In Stock"),
                new Book("Development as Freedom", "Amartya Sen", 1999, "9780465025279", "Economics", "Out of Stock"),
                new Book("Freakonomics", "Steven D. Levitt & Stephen J. Dubner", 2005, "9780393358388", "Economics",
                        "In Stock"),
                new Book("Das Kapital", "Karl Marx", 1867, "9780140449242", "Economics", "Out of Stock"),
                new Book("The Undercover Economist", "Tim Harford", 2005, "9780465026566", "Economics", "In Stock"),
                new Book("Principles of Economics", "Alfred Marshall", 1890, "9780140449204", "Economics", "In Stock"),
                new Book("The Worldly Philosophers", "Robert L. Heilbroner", 1953, "9780393337659", "Economics",
                        "Out of Stock"),
                new Book("Thinking, Fast and Slow", "Daniel Kahneman", 2011, "9780374533551", "Economics", "In Stock"),
                new Book("Nudge", "Richard H. Thaler & Cass R. Sunstein", 2008, "9780143115267", "Economics",
                        "Out of Stock"),
                new Book("The Big Short", "Michael Lewis", 2010, "9780393338823", "Economics", "In Stock"),
                new Book("Global Inequality", "Branko Milanovic", 2016, "9780674987593", "Economics", "In Stock"),
                new Book("Poor Economics", "Abhijit V. Banerjee & Esther Duflo", 2011, "9781610390934", "Economics",
                        "Out of Stock"),
                new Book("The Origins of Totalitarianism", "Hannah Arendt", 1951, "9780156701532", "Political Science",
                        "In Stock"),
                new Book("Man, the State, and War", "Kenneth Waltz", 1959, "9780231188053", "Political Science",
                        "Out of Stock"),
                new Book("Diplomacy", "Henry Kissinger", 1994, "9780671510992", "Political Science", "In Stock"),
                new Book("The Tragedy of Great Power Politics", "John Mearsheimer", 2001, "9780393020254",
                        "Political Science", "In Stock"),
                new Book("Orientalism", "Edward W. Said", 1978, "9780394740670", "History", "Out of Stock"),
                new Book("The Wealth and Poverty of Nations", "David S. Landes", 1998, "9780393318887", "Economics",
                        "In Stock"),
                new Book("The Great Transformation", "Karl Polanyi", 1944, "9780807056431", "Economics",
                        "Out of Stock"),
                new Book("The Affluent Society", "John Kenneth Galbraith", 1958, "9780395925007", "Economics",
                        "In Stock"),
                new Book("An Inquiry into the Nature of Peace", "Immanuel Kant", 1795, "9780872200180",
                        "Political Science", "In Stock"),
                new Book("The Constitution of Liberty", "Friedrich Hayek", 1960, "9780226320840", "Political Science",
                        "Out of Stock"),
                new Book("The Republic", "Plato", 380, "9780140455113", "Political Science", "In Stock"),
                new Book("On Liberty", "John Stuart Mill", 1859, "9780140439144", "Political Science", "Out of Stock"),
                new Book("The Social Contract", "Jean-Jacques Rousseau", 1762, "9780140442014", "Political Science",
                        "In Stock"),
                new Book("The Origins of the Second World War", "A. J. P. Taylor", 1961, "9780684829470", "History",
                        "In Stock"),
                new Book("The Gulag Archipelago", "Aleksandr Solzhenitsyn", 1973, "9780061253713", "History",
                        "Out of Stock"),
                new Book("The Making of the Atomic Bomb", "Richard Rhodes", 1986, "9781451677614", "History",
                        "In Stock"),
                new Book("The Better Angels of Our Nature", "Steven Pinker", 2011, "9780143122012", "History",
                        "Out of Stock"),
                new Book("The Rise of China and the Demise of the Capitalist World System", "Minqi Li", 2008,
                        "9781583671825", "Economics", "In Stock"),
                new Book("The Logic of Collective Action", "Mancur Olson", 1965, "9780674537514", "Economics",
                        "Out of Stock"),
                new Book("The Calculus of Consent", "James M. Buchanan & Gordon Tullock", 1962, "9780865972247",
                        "Economics", "In Stock"),
                new Book("Capitalism, Socialism and Democracy", "Joseph A. Schumpeter", 1942, "9780415107624",
                        "Economics", "In Stock"),
                new Book("The Theory of Moral Sentiments", "Adam Smith", 1759, "9780140449495", "Economics",
                        "Out of Stock"),
                new Book("The Road to Unfreedom", "Timothy Snyder", 2018, "9780525574460", "History", "In Stock"),
                new Book("The Square and the Tower", "Niall Ferguson", 2017, "9780735222915", "History",
                        "Out of Stock"),
                new Book("The Art of War", "Sun Tzu", 500, "9781599869773", "History", "In Stock"),
                new Book("The Origins of Alliances", "Stephen M. Walt", 1987, "9780801494185", "Political Science",
                        "In Stock"),
                new Book("The Economic Consequences of the Peace", "John Maynard Keynes", 1919, "9780486435442",
                        "Economics", "Out of Stock"),
                new Book("The Power Elite", "C. Wright Mills", 1956, "9780195133543", "Political Science", "In Stock"),
                new Book("The Great Divergence", "Kenneth Pomeranz", 2000, "9780691090102", "History", "In Stock"),
                new Book("Capital", "Thomas Piketty", 2014, "9780674430006", "Economics", "In Stock"),
                new Book("Why the Nations Fail", "Daron Acemoglu & James A. Robinson", 2012, "9780307719225",
                        "Economics", "In Stock"),
                new Book("The Narrow Corridor", "Daron Acemoglu & James A. Robinson", 2019, "9780735224384",
                        "Political Science", "Out of Stock"),
                new Book("The Age of Revolution", "Eric Hobsbawm", 1962, "9780674175320", "History", "In Stock"),
                new Book("The Age of Capital", "Eric Hobsbawm", 1975, "9780349104843", "History", "Out of Stock"),
                new Book("The Age of Empire", "Eric Hobsbawm", 1987, "9780679721758", "History", "In Stock"),
                new Book("The Age of Extremes", "Eric Hobsbawm", 1994, "9780679730057", "History", "In Stock"),
                new Book("The Commanding Heights", "Daniel Yergin & Joseph Stanislaw", 1998, "9780684835693",
                        "Economics", "Out of Stock"),
                new Book("The Euro", "Joseph E. Stiglitz", 2016, "9780393254024", "Economics", "In Stock"),
                new Book("The Price of Inequality", "Joseph E. Stiglitz", 2012, "9780393345067", "Economics",
                        "Out of Stock"),
                new Book("The American Revolution: A History", "Gordon S. Wood", 2002, "9780143038423", "History",
                        "In Stock"),
                new Book("The Origins of Modern Science", "Richard S. Westfall", 1971, "9780195135493", "History",
                        "Out of Stock"),
                new Book("The Structure of Scientific Revolutions", "Thomas S. Kuhn", 1962, "9780226458086",
                        "Political Science", "In Stock"),
                new Book("The Politics of Power", "Leslie Lipson", 1964, "9780195006114", "Political Science",
                        "Out of Stock"),
                new Book("An Economic History of the World Since 1400", "Donald J. Harris", 2002, "9780262161320",
                        "Economics", "In Stock"),
                new Book("The Mystery of Capital", "Hernando de Soto", 2000, "9780465013640", "Economics",
                        "Out of Stock"),
                new Book("A Short History of Nearly Everything", "Bill Bryson", 2003, "9780767908184", "History",
                        "In Stock"),
                new Book("The Great Economists: How Their Ideas Can Help Us Today", "Linda Yueh", 2017, "9780691177823",
                        "Economics", "In Stock"),
                new Book("The Age of Revolution: 1789-1848", "Eric Hobsbawm", 1962, "9780674175321", "History",
                        "Out of Stock"),
                new Book("Political Ideologies: An Introduction", "Andrew Heywood", 2017, "9780230361585",
                        "Political Science", "In Stock"),
                new Book("Economics in One Lesson", "Henry Hazlitt", 1946, "9780517548230", "Economics",
                        "Out of Stock"),
                new Book("The Industrial Revolution: A Very Short Introduction", "Robert C. Allen", 2017,
                        "9780198732661", "History", "In Stock"),
                new Book("The Rise of Modern Science", "H. Floris Cohen", 2010, "9780262014469", "History", "In Stock"),
                new Book("The Political Brain", "D. O. Westen", 2007, "9780465015057", "Political Science", "In Stock"),
                new Book("Globalizing Capital", "Barry Eichengreen", 2008, "9780691136019", "Economics",
                        "Out of Stock"),
                new Book("Economic History of the World", "Joel Mokyr", 2016, "9780691177847", "Economics", "In Stock")
        };

        // store the 10 class textbook ISBNs in an ArrayList
        ArrayList<String> isbn = new ArrayList<String>();
        isbn.add("9780140449150");
        isbn.add("9780140449266");
        isbn.add("9780140449280");
        isbn.add("9780226731561");
        isbn.add("9780307387899");
        isbn.add("9780393337642");
        isbn.add("9780465060737");
        isbn.add("9780465093339");
        isbn.add("9780679720201");
        isbn.add("9780691156044");

        // sort books by category, then alphabetically by title
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                int cmp = books[j].genre.compareTo(books[j + 1].genre);
                if (cmp > 0 || (cmp == 0 && books[j].title.compareTo(books[j + 1].title) > 0)) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

        // print all out of stock books
        System.out.println("\n--- Out of Stock Books ---");
        for (Book look : books) {
            if (look.availability.equals("Out of Stock")) {
                System.out.println(look.title);
            }
        }

        // print all books published before 1900
        System.out.println("\n--- Books Published Before 1900 ---");
        for (Book look : books) {
            if (look.year < 1900) {
                System.out.println(look.title);
            }
        }

        // print query results for the 10 class isbns
        System.out.println("\n--- Class Textbook Query Results ---");
        for (Book look : books) {
            if (isbn.contains(look.isbn)) {
                System.out.println(look.title + " | " + look.author + " | " + look.year + " | " + look.isbn + " | "
                        + look.genre + " | " + look.availability);
            }
        }

    }
}
