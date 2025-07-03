import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBooks("1984", "George Orwell", "Fiction", 3);
        lib.addBooks("To Kill a Mockingbird", "Harper Lee", "Fiction", 2);
        lib.addBooks("Pride and Prejudice", "Jane Austen", "Fiction", 4);
        lib.addBooks("A Brief History of Time", "Stephen Hawking", "Science", 2);
        lib.addBooks("The Selfish Gene", "Richard Dawkins", "Science", 3);
        lib.addBooks("Cosmos", "Carl Sagan", "Science", 2);
        lib.addBooks("Clean Code", "Robert C. Martin", "Programming", 5);
        lib.addBooks("Effective Java", "Joshua Bloch", "Programming", 3);
        lib.addBooks("Introduction to Algorithms", "Cormen et al.", "Programming", 2);
        lib.addBooks("Sapiens", "Yuval Noah Harari", "History", 3);
        lib.addBooks("Guns, Germs, and Steel", "Jared Diamond", "History", 2);
        lib.addBooks("The Silk Roads", "Peter Frankopan", "History", 2);
        lib.addBooks("Atomic Habits", "James Clear", "Self-Help", 4);
        lib.addBooks("The Subtle Art of Not Giving a F*ck", "Mark Manson", "Self-Help", 3);
        lib.addBooks("Think and Grow Rich", "Napoleon Hill", "Self-Help", 2);



        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== WELCOME TO ASINT LIBRARY ===");

            System.out.println("1. View all books");

            System.out.println("2. Add books");

            System.out.println("3. Borrow a book");

            System.out.println("4. Return a book");

            System.out.println("5. Search by author");

            System.out.println("6. Search by genre");

            System.out.println("7. Search by title");

            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            int option;
            try {
                // option = Integer.parseInt(sc.nextLine());
                option=sc.nextInt();
                sc.nextLine();
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (option) {
                case 1:
                    lib.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Number of copies: ");
                    int copies = Integer.parseInt(sc.nextLine());

                    lib.addBooks(title, author, genre, copies);
                    System.out.println("Book(s) added.");
                    break;

                case 3:
                    System.out.print("Enter title to borrow: ");
                    String bTitle = sc.nextLine();
                    System.out.print("Enter author: ");
                    String bAuthor = sc.nextLine();
                    lib.borrowBook(bTitle, bAuthor);
                    break;

                case 4:
                    System.out.print("Enter title to return: ");
                    String rTitle = sc.nextLine();
                    System.out.print("Enter author: ");
                    String rAuthor = sc.nextLine();
                    lib.returnBook(rTitle, rAuthor);
                    break;

                case 5:
                    System.out.print("Enter author to search: ");
                    lib.searchByAuthor(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter genre to search: ");
                    lib.searchByGenre(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter title to search: ");
                    lib.searchByTitle(sc.nextLine());
                    break;

                case 0:
                    System.out.println("Thankyou for visting Library!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

