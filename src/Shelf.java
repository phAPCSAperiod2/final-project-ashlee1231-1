import java.util.ArrayList;

/**
 * Represents a bookshelf that organizes books into read books, want-to-read
 * books, and a 2D array of favorite books.
 *
 * This class manages a personal book collection with three organizational
 * systems: a list of books already read, a list of books the user wants to read,
 * and a 2D array (3x2) for displaying favorite books. It provides methods to
 * add books, move books between lists, and display the shelf contents in
 * a formatted manner.
 */
public class Shelf {
    private ArrayList<Book> readBooks;
    private ArrayList<Book> wantBooks;
    private Book[][] topBooks;

    /**
     * Creates a new empty shelf with initialized lists and a 3x2 array for favorite
     * books.
     */
    public Shelf() {
        this.readBooks = new ArrayList<Book>();
        this.wantBooks = new ArrayList<Book>();
        this.topBooks = new Book[2][3];
    }

    /**
     * Adds a book to the appropriate list based on its read status.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        if (book.getReadStatus()) {
            readBooks.add(book);
        } else {
            wantBooks.add(book);
        }
    }

    /**
     * Adds a book to the favorites array at the specified position.
     *
     * @param row  the row index (0-2)
     * @param col  the column index (0-1)
     * @param book the book to add to favorites
     */
    public void addToFavorites(int row, int col, Book book) {
        topBooks[row][col] = book;
    }

    /**
     * Checks if an ArrayList is empty by checking if the first element is null.
     * Note: This method may not work correctly for ArrayLists that can contain null
     * elements.
     *
     * @param list the ArrayList to check
     * @return true if the list appears empty, false otherwise
     */
    public boolean isEmptyList(ArrayList<Book> list) {
        if (list.get(0) == null) {
            return true;
        }
        return false;
    }

    /**
     * Prints the contents of an ArrayList of books in a comma-separated format.
     *
     * @param list the ArrayList of books to print
     */
    public static void printArrayList(ArrayList<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println("and " + list.get(i).getTitle());
            } else {
                System.out.print(list.get(i).getTitle() + ", ");
            }
        }
    }
    /**
     * Moves a book from the want-to-read list to the read list.
     * Assumes the book is currently in the want-to-read shelf.
     * Assumes the read status was changed before method call.
     *
     * @param book the book to move from want-to-read to read
     */
    public void moveBook(Book book) {
            wantBooks.remove(book);
            readBooks.add(book);
    }

    /**
     * Prints all read books with their ratings in a comma-separated format.
     * The last book is preceded by "and".
     */
    public void printRatings() {
        for (int i = 0; i < readBooks.size(); i++) {
            if (i == readBooks.size() - 1) {
                System.out.println("and " + readBooks.get(i).getTitle() + " " + readBooks.get(i).getRating());
            } else {
                System.out.print(readBooks.get(i).getTitle() + " " + readBooks.get(i).getRating() + ", ");
            }
        }
    }

    /**
     * Prints the contents of a 2D array of books.
     *
     * @param list the 2D array of books to print
     */
    private static void print2D(Book[][] list) {
        //check if entire row is empty
        boolean read = true;
        boolean want = true;
        for (int i = 0; i < 2; i++) {
            if (list[0][i] != null) {
                break;
            }
            read = false;
        }
        for (int i = 0; i <= 2; i++) {
            if (list[1][i] != null) {
                break;
            }
            want = false;
        }
        if (!read) {
                    System.out.println("You have not added any read books to favorites.");
                }
        boolean message = false;
        for (int row = 0; row < list.length; row++) {
            for (int col = 0; col < list[row].length; col++) {
                if (!want && !message) {
                    System.out.println("You have not added any want to read books to favorites");
                    message = true;
                }
                else if (list[row][col] == null) {
                    System.out.print("");
                } else {
                    System.out.println(list[row][col].getTitle());
                }
            }
        }
    }

    /**
     * Prints the entire shelf contents, including read books, want-to-read books,
     * and favorite books.
     */
    public void print() {
        System.out.println("This is your shelf!");
        System.out.println("Read:");
        if (readBooks.isEmpty()) {
            System.out.println("None");
        } else {
            printArrayList(readBooks);
        }

        System.out.println("Want to Read:");
        if (wantBooks.isEmpty()) {
            System.out.println("None");
        } else {
            printArrayList(wantBooks);
        }

        print2D(topBooks);

    }

    public void printAverages() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < readBooks.size(); i++) {
            total += readBooks.get(i).getRating();
            count++;
        }
        System.out.println("Your average rating is " + total/count + ".");
    }

    public Book findBook(String title) {
        for (int i = 0; i < wantBooks.size(); i++) {
            if (wantBooks.get(i).getTitle().equals(title)) {
            return wantBooks.get(i);
            }
        }
        return null;
    }

}

