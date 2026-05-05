import java.util.InputMismatchException;
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
        Book book1 = new Book("A study in drowning", 4);
        Book book2 = new Book("Blood over bright haven", 4.5);
        Shelf shelf1 = new Shelf();
        shelf1.addBook(book1);
        shelf1.addBook(book2);

        int userInput = -1;
        String userContinue = "Yes";
        Shelf shelf = new Shelf();
        Scanner scan = new Scanner(System.in);
        while (userContinue.equalsIgnoreCase("Yes")) {
            System.out.println("Welcome to Your Shelf!");
            printMenu();

            boolean validInput = false;
            do {
                try {
                    System.out.println("Enter a number: ");
                    userInput = scan.nextInt();
                    scan.nextLine();
                    validInput = true;
                }
                catch (InputMismatchException e ) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
                }
            } while (!validInput);


            goMenu(userInput, shelf);

            //end of method
            System.out.println("Continue using shelf? Type yes if so!");
            try {
                userContinue = scan.nextLine();
            }
            catch (InputMismatchException f ) {
                System.out.println("Sorry, that is not a valid input. Please type the phrase");
            }

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
        response = getValidInt(scan);
        while (response < 1 || response > 2) {
            System.out.println("Please enter a 1 or 2");
            response = getValidInt(scan);
        }
        if (response == 1) {
            System.out.println("Adding a book you've read...");
            System.out.println("What is the name of the book?");
            String title = getValidString(scan);
            System.out.println("What do you rate it? (Counts decimals):");
            double rating = getValidDouble(scan);
            while (rating < 0 || rating > 5) {
                System.out.println("Please enter a value 1-5");
                rating = getValidDouble(scan);
            }
            Book newBook = new Book(title, rating);
            shelf.addBook(newBook);
            System.out.println("You have added the book " + newBook.toString() + " to your read books!");
        } else {
            System.out.println("Adding a book you want to read...");
            System.out.println("What is the name of the book?");
            String title = getValidString(scan);
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
        String titleName = getValidString(scan);
        Book updateBook = shelf.findBook(titleName, 1);
        if (updateBook == null) {
            System.out.println("Sorry, that book is not in your records.");
        }
        else {
            System.out.println("What are you going to rate this book?");
            double rating = getValidDouble(scan);
            scan.nextLine();
            while (rating < 0 || rating > 5) {
                System.out.println("Please enter a rating 1-5");
                rating = getValidDouble(scan);
            }
            updateBook.setRating(rating);
            shelf.moveBook(updateBook);
        }

    }

    /**
     * Adds a selected book to the favorites section of the shelf.
     *
     * @param shelf the shelf containing the book to add to favorites
     */
    public static boolean addToFavies(Shelf shelf) {
        Scanner scan = new Scanner(System.in);
        int index = -1;
        System.out.println("Are you adding a favorite too...");
        System.out.println("0) Adding a read book to favorites");
        System.out.println("1) Adding an unread book to top priority");
        int response = getValidInt(scan);
        System.out.println("What book do you want to add?");
        String titleOfBook = getValidString(scan);
        Book book = shelf.findBook(titleOfBook, response);
        if (book == null) {
            System.out.println("Could not locate that book in your records. Try adding the book first?");
            return false;
        }
        else {
        // if there is a null element, add to the first instance of a null.
        if (shelf.nullElementFound(response)) {
            index = shelf.findIndexOfNull(response);
            shelf.addToFavorites(response, index, book);
            System.out.println("Added " + book.toString() + " to favorites!");
        }
        // if there are three items, choose one index to replace
        else {
            int secRes = 0;
            System.out.println("Uh oh! You already have 3 books in favorites...");
            System.out.println("Which do you want to replace?");
            System.out.println("0) Existing Book");
            System.out.println("1) Nevermind");
            secRes = getValidInt(scan);
            scan.nextLine();
            if (secRes == 0) {
                System.out.println("Which book do you want to remove?");
                String titleOfRev = getValidString(scan);
                Book bookToRemove = shelf.findBook(titleOfRev, response);
                index = shelf.returnIndex(bookToRemove, response);
                shelf.addToFavorites(response, index, book);
                System.out.println("Successfully added the book!");
            }
        }
    }
        return true;
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

    public static int getValidInt(Scanner scan) {
        int num = -1;
        boolean valid = false;
        do {
            try {
                System.out.print("Enter a number: ");
                num = scan.nextInt();
                scan.nextLine(); // consume newline
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); // clear bad input
            }
        } while (!valid);
        return num;

    }

    public static double getValidDouble(Scanner scan) {
        double dob = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Enter a rating (decimals are considered): ");
                dob = scan.nextDouble();
                scan.nextLine(); // consume newline
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); // clear bad input
            }
        } while (!valid);
        return dob;

    }

    public static String getValidString(Scanner scan) {
        String string = "";
        boolean valid = false;
        do {
            try {
                System.out.print("Enter the name: ");
                string = scan.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!valid);
        return string;

    }


}
