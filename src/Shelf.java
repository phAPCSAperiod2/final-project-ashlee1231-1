import java.util.ArrayList;

public class Shelf {
    private ArrayList<Book> readBooks;
    private ArrayList<Book> wantBooks;
    private Book[][] topBooks;

    //constructor
    public Shelf() {
        this.readBooks = new ArrayList<Book>();
        this.wantBooks = new ArrayList<Book>();
        this.topBooks = new Book[3][2];
    }

    //add a book, specifies list through number
    public void addBook(Book book) {
        if (book.getReadStatus()) {
            readBooks.add(book);
        }
        else {
            wantBooks.add(book);
        }
    }

    //adds a books to favorites
    public void addToFavorites(int row, int col, Book book) {
        topBooks[row][col] = book;
    }

    //checks if an arraylist is empty
    public boolean isEmptyList(ArrayList<Book> list) {
        if (list.get(0) == null) {
            return true;
        }
        return false;
    }


    private static void printArrayList(ArrayList<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println("and " + list.get(i).getTitle());
            }
            else {
                System.out.print(list.get(i).getTitle() + ", ");
            }
        }
    }

    private static void print2D(Book[][] list) {
        for (int row = 0; row < list.length; row++) {
                for (int col = 0; col < list[col].length; col++) {
                    if (row == 1 && col == 0) {
                        System.out.println("Your Top Books You Want to Read:");
                    }
                    if (list[row][col] == null) {
                        System.out.print(" ");
                    }
                    else {
                    System.out.println(list[row][col].getTitle());
                    }
                }
            }
    }


    //Shelf prints if there is either an item in index 0 (for arraylists) and only if the item is not null (2D Array)
    public void print() {
        System.out.println("This is your shelf!");
        System.out.println("Read:");
        if (readBooks.isEmpty()) {
            System.out.println("None");
        }
        else {
            printArrayList(readBooks);
        }

        System.out.println("Want to Read:");
        if (wantBooks.isEmpty()) {
            System.out.println("None");
        }
        else {
            printArrayList(wantBooks);
        }

        System.out.println("Your Favorite Read Books:");
        print2D(topBooks);

        }

    }

