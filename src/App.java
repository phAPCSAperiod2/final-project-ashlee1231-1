/**
 * Main application class that demonstrates the Book and Shelf classes.
 *
 * This class serves as the entry point for the application. It creates
 * sample Book objects, adds them to a Shelf, and demonstrates the functionality
 * of updating book properties and moving books between reading lists.
 * The application then displays the organized shelf contents.
 */
public class App {
    /**
     * Main method that runs the application.
     *
     * @param args command line arguments (not used)
     * @throws Exception if an error occurs
     */
    public static void main(String[] args) throws Exception {

        // Create a book that you want to read
        Book book1 = new Book("A Study in Drowning");

        // Create a book that you already read
        Book book2 = new Book("Blood Over Bright Haven", 5);

        // Some other books to add to Shelf
        Book book3 = new Book("Mistborn", 5.0);
        Book book4 = new Book("The Will of the Many");
        Book book5 = new Book("Project Hail Mary", 4);
        Book book6 = new Book("The Secret History", 4);
        Book book7 = new Book("Yumi and the Nightmare Painter", 4.5);
        Book book8 = new Book("The Raven Scholar");
        Book book9 = new Book("Sword of Kaigen");

        // Testing toString methods
        System.out.println(book1.toString());
        System.out.println(book2.toString());

        // update status of the want to read book, update rating
        book1.setReadStatus(true);
        if (book1.setRating(5)) {
            System.out.println(book1.toString());
        }
        // Creating a Shelf
        Shelf shelf = new Shelf();
        shelf.addBook(book2);
        shelf.addBook(book3);
        shelf.addBook(book4);
        shelf.addBook(book5);
        shelf.addBook(book6);
        shelf.addBook(book7);
        shelf.addBook(book8);
        shelf.addBook(book9);

        shelf.print();

        //update the read status of a book
        book4.setReadStatus(true);
        book4.setRating(5);
        shelf.moveBook(book4);

        shelf.print();

        System.out.println("Printing ratings...");
        shelf.printRatings();
    }

}
