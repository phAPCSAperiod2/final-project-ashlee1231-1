public class Book {
    private String title;
    private double rating;
    private boolean isRead;

    //Create a book that wants to be read
    public Book(String title) {
        this.title = title;
        this.isRead = false;
    }

    //Create a book that is already read
    public Book(String title, double rating) {
        this.title = title;
        this.rating = rating;
        this.isRead = true;
    }

    public boolean setRating(double rating) {
        if (rating > 0 && rating <= 5) {
            this.rating = rating;
            return true;
        }
        return false;
    }

    public void setReadStatus(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean getReadStatus() {
        return isRead;
    }

    public String getTitle(){
        return title;
    }

    public String toString() {
        if (isRead == true) {
            return title + ": " + rating;
        }
        else {
            return title;
        }
    }


}
