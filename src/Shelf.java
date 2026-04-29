import java.util.ArrayList;

/**
 * Represents a bookshelf that organizes books into read books, want-to-read
 * books, and a 2D array of favorite books.
 *
 * This class manages a personal book collection with three organizational
 * systems: a list of books already read, a list of books the user wants to read,
 * and a 2D favorites array (2 rows by 3 columns). It provides methods to
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
     * @param row  the row index (0-1)
     * @param col  the column index (0-2)
     * @param book the book to add to favorites
     */
    public void addToFavorites(int row, int col, Book book) {
        topBooks[row][col] = book;
    }

    /**
     * Finds the first empty position in the specified favorites row.
     *
     * @param num the favorites row to search
     * @return the first column index with a null entry, or -1 if none is found
     */
    public int findIndexOfNull(int num) {
        for (int i = 0; i < topBooks[num].length; i++) {
            if (topBooks[num][i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the column index of a book in the specified favorites row.
     *
     * @param book the book to locate
     * @param row the favorites row to search
     * @return the column index of the book, or -1 if not found
     */
    public int returnIndex(Book book, int row) {
        int num = -1;
        for (int i = 0; i < topBooks[0].length; i++) {
            if (topBooks[row][i].equals(book)) {
                num = i;
            }
        }
        return num;
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
        boolean oneBook = false;
        if (list.size() == 1) {
            System.out.println(list.get(0).toString());
            oneBook = true;
        }
        if (!oneBook) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println("and " + list.get(i).toString());
            } else {
                System.out.print(list.get(i).toString() + ", ");
            }
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
     * Checks whether the specified favorites row contains any empty slots.
     *
     * @param num the favorites row to check
     * @return true if the row contains no null entries, false otherwise
     */
    public boolean nullElementFound(int num) {
        for (int i = 0; i < topBooks.length; i++) {
            if (topBooks[num][i] == null) {
                System.out.println("Found null element at " + i);
                return true;
            }
        }
        System.out.println("There are no null elements");
        return false;
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
        for (int i = 0; i < 2; i++) {
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

    /**
     * Prints the average rating for all books in the read-books list.
     */
    public void printAverages() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < readBooks.size(); i++) {
            total += readBooks.get(i).getRating();
            count++;
        }
        System.out.println("Your average rating is " + total/count + ".");
    }

    /**
     * Finds a book by title in either the want-to-read or read list.
     *
     * @param title the title of the book to find
     * @param num 1 to search want-to-read books, otherwise searches read books
     * @return the matching Book if found, or null if no match exists
     */
    public Book findBook(String title, int num) {
        //loop for want book
        if (num == 1) {
            for (int i = 0; i < wantBooks.size(); i++) {
                if (wantBooks.get(i).getTitle().equals(title)) {
                    return wantBooks.get(i);
                }
            }
        }
        //loop for read book
        else {
            for (int i = 0; i < readBooks.size(); i++) {
                if (readBooks.get(i).getTitle().equals(title)) {
                    return readBooks.get(i);
                }
            }
        }
        return null;
    }

}

