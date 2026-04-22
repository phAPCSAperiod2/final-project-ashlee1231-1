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

        System.out.println("");

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

        System.out.println("");

        System.out.println("Printing ratings...");
        shelf.printRatings();
        shelf.printAverages();
    }
    //1 is print
    //2 add book (make object then call add method)
    //3 update status
    //4 add book to favorites (check to see if there's another item, if there is, add behind)
    //5 print

    public static void menu(int num, Shelf shelf) {
        if (num == 1) {
            shelf.print();
        }
        if (num == 2) {
            makeBook(shelf);
        }
        if (num == 3) {
            updateBook(shelf);
        }
    }

    public static void makeBook(Shelf shelf) {
        int response = 0;
        System.out.println("Are you..");
        System.out.println("1) Adding a book you've read");
        System.out.println("2) Adding a book you want to read?");
        System.out.println("Enter the number:");
        if (response == 1) {
            double rating = 0;
            String title = "";
            Book newBook = new Book(title, rating);
            shelf.addBook(newBook);
        }
        else {
            String title = "";
            Book newBook = new Book(title);
            shelf.addBook(newBook);
        }
    }

    public static void updateBook(Shelf shelf) {
        System.out.println("Which book do you want to update?");
        String titleName = "";
        Book updateBook = shelf.findBook(titleName);
        System.out.println("What are you going to rate this book?");
        double rating = 0;
        updateBook.setRating(rating);
        shelf.moveBook(updateBook);

    }
}
