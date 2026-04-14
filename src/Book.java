/**
 * Represents a book with a title, rating, and read status.
 * 
 * This class encapsulates a single book with properties for its title,
 * rating (1-5 scale), and whether it has been read. Books can be created
 * as either read with a rating or unread without a rating. The class provides
 * methods to update read status, set ratings, and retrieve book information.
 */
public class Book {
    private String title;
    private double rating;
    private boolean isRead;

    /**
     * Creates a new book that wants to be read (unread status).
     *
     * @param title the title of the book
     */
    public Book(String title) {
        this.title = title;
        this.isRead = false;
    }

    /**
     * Creates a new book that is already read with a given rating.
     *
     * @param title  the title of the book
     * @param rating the rating of the book (between 1 and 5)
     */
    public Book(String title, double rating) {
        this.title = title;
        this.rating = rating;
        this.isRead = true;
    }

    /**
     * Sets the rating for this book if the rating is valid (between 1 and 5).
     *
     * @param rating the rating to set
     * @return true if the rating was set successfully, false otherwise
     */
    public boolean setRating(double rating) {
        if (rating > 0 && rating <= 5) {
            this.rating = rating;
            return true;
        }
        return false;
    }

    /**
     * Sets the read status of this book.
     *
     * @param isRead true if the book has been read, false otherwise
     */
    public void setReadStatus(boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * Gets the read status of this book.
     *
     * @return true if the book has been read, false otherwise
     */
    public boolean getReadStatus() {
        return isRead;
    }

    /**
     * Gets the title of this book.
     *
     * @return the title of the book
     */
    /**
     * Gets the title of this book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the rating of this book.
     *
     * @return the rating of the book (between 1 and 5), or 0 if not set
     */
    public double getRating() {
        return rating;
    }

    /**
     * Returns a string representation of this book.
     * If the book is read, includes the rating; otherwise, just the title.
     *
     * @return a string representation of the book
     */
    public String toString() {
        if (isRead == true) {
            return title + ": " + rating;
        } else {
            return title;
        }
    }

}
