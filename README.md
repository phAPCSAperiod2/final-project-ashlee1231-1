# Personal Bookshelf Management System

## Executive Summary
The Personal Bookshelf Management System is a robust, console-based Java application designed to empower avid readers with comprehensive tools for organizing and tracking their literary collections. This solution enables users to maintain detailed records of read and unread books, manage ratings, curate personalized favorites, and generate insightful analytics on reading habits. Developed with a focus on user experience and data integrity, the system provides a scalable foundation for personal book management.

## Key Features
- **Comprehensive Book Tracking**: Seamlessly add and categorize books as either read (with user-assigned ratings) or pending (want-to-read list).
- **Dynamic Status Updates**: Easily transition books between categories and update ratings as reading progress evolves.
- **Curated Favorites System**: Organize up to three favorite books in dedicated categories for read and unread selections, with intelligent replacement logic.
- **Analytical Insights**: Calculate and display average ratings across all read books to inform reading preferences.
- **Robust Input Validation**: Ensure data accuracy with comprehensive error handling and user-friendly prompts.
- **Modular Architecture**: Clean, object-oriented design facilitating future enhancements and maintenance.

## Target Audience
This application is tailored for:
- Dedicated readers seeking efficient organization of their personal libraries.
- Individuals interested in tracking reading progress and performance metrics.
- Users requiring a reliable, offline solution for book management without external dependencies.

## Installation and Usage
### Prerequisites
- Java Development Kit (JDK) 17 or higher installed on the target system.

### Deployment Steps
1. Clone or download the project repository to your local environment.
2. Navigate to the project root directory in your terminal.
3. Compile the source code: `javac -d bin src/*.java`
4. Execute the application: `java -cp bin App`
5. Interact with the system via the intuitive menu-driven interface, following on-screen instructions for all operations.

### User Interface
The application features a text-based menu system with the following options:
- Print Shelf: Display the complete bookshelf overview.
- Make a Book: Add new books to the collection.
- Update a Book as Read: Modify book status and ratings.
- Add a Book to Favorites: Curate favorite selections.
- Find Book Rating Averages: Generate rating analytics.

## Technical Architecture
### Core Components
- **App Class**: Serves as the primary entry point, managing user interactions and orchestrating system operations through a centralized menu system.
- **Book Class**: Encapsulates book entities with attributes including title, rating, and read status, providing essential getter/setter methods and string representation.
- **Shelf Class**: Implements collection management using ArrayList structures for dynamic read and want-to-read lists, complemented by a 2x3 2D array for structured favorite organization.

### Data Structures and Algorithms
- **ArrayList<Book>**: Employed for flexible storage of read and unread book collections, supporting dynamic sizing and efficient insertion/removal operations.
- **Book[][] (2x3 Array)**: Dedicated structure for favorites management, enabling categorized storage with built-in capacity limits and replacement mechanisms.
- **Search and Retrieval**: Optimized linear search algorithms for book location across collections.
- **Input Processing**: Comprehensive validation routines ensuring data type integrity and user experience continuity.

### Design Principles
- **Object-Oriented Design**: Modular class structure promoting code reusability and maintainability.
- **Encapsulation**: Private data members with controlled access through public methods.
- **Error Handling**: Graceful exception management for input validation and edge cases.
- **Scalability Considerations**: Architecture designed to accommodate future expansions such as GUI interfaces, data persistence, and advanced search capabilities.

## Class Diagram
[View Detailed Class Diagram]![Class Diagram](images/class-diagram.png)

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

## Limitations and Future Roadmap
### Current Constraints
- Console-based interface limits accessibility for non-technical users.
- Lack of persistent storage results in data loss upon session termination.
- Favorites limited to three entries per category.
- Basic input validation may not cover all edge cases.

### Planned Enhancements
- Implementation of graphical user interface (GUI) for improved user experience.
- Integration of database persistence for data retention across sessions.
- Expansion of favorites capacity and introduction of custom categories.
- Advanced search and filtering capabilities.
- Potential integration with online book databases for metadata enrichment.
- Mobile application development for cross-platform accessibility.

## Conclusion
The Personal Bookshelf Management System represents a solid foundation for personal book organization, combining technical robustness with user-centric design. This application demonstrates strong software engineering principles and provides a scalable platform for future development. We recommend this solution for individuals and organizations seeking reliable, efficient book management tools.
