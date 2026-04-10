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

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReadStatus(boolean isRead) {
        this.isRead = isRead;
    }

    public String getTitle(){
        return title;
    }


}
