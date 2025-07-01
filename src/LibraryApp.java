import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        boolean running = true;

        System.out.println("📚 Welcome to the Library Management System!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                    break;
                case 2:
                    lib.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    lib.borrowBook(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 5:
                    running = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
