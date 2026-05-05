# Personal Bookshelf Manager

## What This Software Does
This is a console-based Java application that allows users to manage their personal bookshelf. Users can add books they've read (with ratings) or books they want to read, update book statuses, organize favorites, and view their collection with average ratings.

## Who It’s For
This software is designed for book lovers who want to keep track of their reading progress, maintain a wishlist of books to read, and highlight their favorite books in an organized way.

## How to Run the Program
1. Ensure you have Java installed on your system.
2. Compile the Java files: `javac src/*.java`
3. Run the application: `java -cp src App`
4. Follow the on-screen menu prompts to interact with your bookshelf.

## Technical Overview
- **Main Classes**:
  - `App`: The driver class with the main method and menu system.
  - `Book`: Represents individual books with title, rating, and read status.
  - `Shelf`: Manages collections of books using ArrayLists for read/want-to-read lists and a 2D array for favorites.
- **Key Data Structures**: ArrayList for dynamic lists of books, 2D array (2x3) for organizing favorite books.
- **Program Logic**: Menu-driven interface with input validation, allowing users to add, update, and display books.

## Class Diagram
https://drive.google.com/file/d/1j04iqHtp2AbXCo4An7wnjB1WUAlBQ7HE/view?usp=sharing

```
App
├── main(String[] args)
├── printMenu()
├── goMenu(int, Shelf)
├── makeBook(Shelf)
├── updateBook(Shelf)
├── addToFavies(Shelf)
└── averages(Shelf)

Book
├── title: String
├── rating: double
├── isRead: boolean
├── constructors
├── setRating(double)
├── setReadStatus(boolean)
├── getters
└── toString()

Shelf
├── readBooks: ArrayList<Book>
├── wantBooks: ArrayList<Book>
├── topBooks: Book[2][3]
├── addBook(Book)
├── addToFavorites(int, int, Book)
├── moveBook(Book)
├── print()
├── printAverages()
├── findBook(String, int)
└── other helper methods
```

## Known Limitations / Future Improvements
- Currently console-based; a GUI could enhance usability.
- No data persistence; books are lost when the program exits.
- Limited to 3 favorites per category; could be expanded.
- Input validation could be more robust.
- Future versions could include search functionality, book recommendations, or integration with online book databases.
