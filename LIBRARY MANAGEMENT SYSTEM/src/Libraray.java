import java.util.*;

class Library {
    private final Map<Book, Integer> bookStorage = new HashMap<>();

    public void addBooks(String title, String author, String genre, int copies) {
        Book newBook = new Book(title, author, genre);
        int current = bookStorage.getOrDefault(newBook, 0);
        bookStorage.put(newBook, current + copies);
    }

    public void displayAllBooks() {
        if (bookStorage.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("All Avilable Books in libarary");
        for (Map.Entry<Book, Integer> entry : bookStorage.entrySet()) {
            System.out.println(entry.getKey() + " | Copies: " + entry.getValue());
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book b : bookStorage.keySet()) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b + " | Copies: " + bookStorage.get(b));
                found = true;
            }
        }
        if (!found) System.out.println("No book found with title \"" + title + "\".");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book b : bookStorage.keySet()) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b + " | Copies: " + bookStorage.get(b));
                found = true;
            }
        }
        if (!found) System.out.println("No books found by " + author + ".");
    }

    public void searchByGenre(String genre) {
        boolean found = false;
        for (Book b : bookStorage.keySet()) {
            if (b.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(b + " | Copies: " + bookStorage.get(b));
                found = true;
            }
        }
        if (!found) System.out.println("No books found in genre " + genre + ".");
    }

    public void borrowBook(String title, String author) {
        Book target = new Book(title, author,""); 
        if (bookStorage.containsKey(target)) {
            int copies = bookStorage.get(target);
            if (copies > 0) {
                bookStorage.put(target, copies - 1);
                System.out.println("You have borrowed: \"" + title + "\"");
            } else {
                System.out.println("No copies available for \"" + title + "\".");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title, String author) {

        Book target = new Book(title, author, "");
        if (bookStorage.containsKey(target)) {
            int copies = bookStorage.get(target);
            bookStorage.put(target, copies + 1);
            System.out.println("You have returned: \"" + title + "\"");
        } else {
            System.out.println("Book not found in library. Please provide genre to add it as new:");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter genre: ");
            String genre = sc.nextLine();
            bookStorage.put(new Book(title, author, genre), 1);
            System.out.println("Book added to library with 1 copy.");
        }
    }
}

