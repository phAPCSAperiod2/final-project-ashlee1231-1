import java.util.Scanner;
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
        String userContinue = "Yes";
        Shelf shelf = new Shelf();
        Scanner scan = new Scanner(System.in);
        while (userContinue.equalsIgnoreCase("Yes")) {
            System.out.println("Welcome to Your Shelf!");
            printMenu();

            //user input
            int userInput = scan.nextInt();
            scan.nextLine();
            //put a try else here
            goMenu(userInput, shelf);

            //end of method
            System.out.println("Continue using shelf? Type yes if so!");
            userContinue = scan.nextLine();

        }

        scan.close();

    }

    public static void printMenu() {
        System.out.println("Please choose from the following options...");
        System.out.println("1) Print Shelf");
        System.out.println("2) Make a Book");
        System.out.println("3) Update a Book as Read");
        System.out.println("4) Add a Book to Favorites");
        System.out.println("5) Find Book Rating Averages");
    }

    /**
     * Processes a menu selection and performs the matching shelf action.
     *
     * @param num   the menu option number selected by the user
     * @param shelf the shelf to operate on
     */
    public static void goMenu(int num, Shelf shelf) {
        if (num == 1) {
            shelf.print();
        }
        else if (num == 2) {
            makeBook(shelf);
        }
        else if (num == 3) {
            updateBook(shelf);
        }
        else if (num == 4) {
            addToFavies(shelf);
        }
        else if (num == 5) {
            averages(shelf);
        }
        else {
            System.out.println("Not a valid input. Try again");
        }
    }

    /**
     * Prompts for book information and adds a new book to the shelf.
     *
     * @param shelf the shelf to add the new book to
     */
    public static void makeBook(Shelf shelf) {
        Scanner scan = new Scanner(System.in);
        int response = 0;
        System.out.println("Are you..");
        System.out.println("1) Adding a book you've read");
        System.out.println("2) Adding a book you want to read?");
        System.out.println("Enter the number:");
        response = scan.nextInt();
        scan.nextLine();
        if (response == 1) {
            System.out.println("Adding a book you've read...");
            System.out.println("What is the name of the book?");
            String title = scan.nextLine();
            System.out.println("What do you rate it? (Counts decimals):");
            double rating = scan.nextDouble();
            Book newBook = new Book(title, rating);
            shelf.addBook(newBook);
            System.out.println("You have added the book " + newBook.toString() + " to your read books!");
        } else {
            System.out.println("Adding a book you want to read...");
            System.out.println("What is the name of the book?");
            String title = scan.nextLine();
            Book newBook = new Book(title);
            shelf.addBook(newBook);
            System.out.println("You have added the book " + newBook.toString() + " to your want to read books!");
        }
    }

    /**
     * Updates the rating and reading status for an existing book on the shelf.
     *
     * @param shelf the shelf containing the book to update
     */
    public static void updateBook(Shelf shelf) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which book do you want to update?");
        String titleName = scan.nextLine();
        Book updateBook = shelf.findBook(titleName, 1);
        System.out.println("What are you going to rate this book?");
        double rating = scan.nextDouble();
        scan.nextLine();
        updateBook.setRating(rating);
        shelf.moveBook(updateBook);

    }

    /**
     * Adds a selected book to the favorites section of the shelf.
     *
     * @param shelf the shelf containing the book to add to favorites
     */
    public static void addToFavies(Shelf shelf) {
        Scanner scan = new Scanner(System.in);
        int index = -1;
        System.out.println("Are you adding a favorite too...");
        System.out.println("0) Adding a read book to favorites");
        System.out.println("1) Adding an unread book to top priority");
        int response = scan.nextInt();
        scan.nextLine();
        System.out.println("What book do you want to add?");
        String titleOfBook = scan.nextLine();
        Book book = shelf.findBook(titleOfBook, response);
        // if there is a null element, add to the first instance of a null.
        if (shelf.nullElementFound(response)) {
            index = shelf.findIndexOfNull(response);
            shelf.addToFavorites(response, index, book);
        }
        // if there are three items, choose one index to replace
        else {
            int secRes = 0;
            System.out.println("Uh oh! You already have 3 books in favorites...");
            System.out.println("Which do you want to replace?");
            System.out.println("0) Existing Book");
            System.out.println("1) Nevermind");
            secRes = scan.nextInt();
            scan.nextLine();
            if (secRes == 0) {
                System.out.println("Which book do you want to remove?");
                String titleOfRev = scan.nextLine();
                Book bookToRemove = shelf.findBook(titleOfRev, response);
                index = shelf.returnIndex(bookToRemove, response);
                shelf.addToFavorites(response, index, book);
                System.out.println("Successfully added the book!");
            }
        }
    }

    /**
     * Displays the average rating for all books marked as read on the shelf.
     *
     * @param shelf the shelf whose average rating should be printed
     */
    public static void averages(Shelf shelf) {
        System.out.println("This is your average rating of all books you have read!");
        shelf.printAverages();
    }
}
