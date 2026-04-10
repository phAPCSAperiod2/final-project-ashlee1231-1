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
    public void addBook(int number, Book book) {
        if (number == 1) {
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

    public void printShelf() {
        System.out.println("This is your shelf!");
        System.out.println("Read");
        for (int i = 0; i < readBooks.size(); i++) {
            System.out.print(readBooks.get(i).getTitle());
        }
        System.out.println("Want to Read:");
        for (int i = 0; i < wantBooks.size(); i++) {
            System.out.print(wantBooks.get(i).getTitle());
        }
        System.out.println("Your Favorite Read Books:");
            for (int row = 0; row < topBooks.length; row++) {
                for (int col = 0; col < topBooks[col].length; col++) {
                    if (row == 1 && col == 0) {
                        System.out.println("Your Top Books You Want to Read");
                    }
                    System.out.println(topBooks[row][col].getTitle());
                }
            }
        }

    }

