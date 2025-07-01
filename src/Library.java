import java.io.*;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.txt";

    public Library() {
        loadBooksFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public void borrowBook(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                if (!b.isBorrowed()) {
                    b.borrow();
                    saveBooksToFile();
                    System.out.println("Book borrowed!");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                if (b.isBorrowed()) {
                    b.returned();
                    saveBooksToFile();
                    System.out.println("Book returned!");
                } else {
                    System.out.println("Book wasn't borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void saveBooksToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                bw.write(b.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(Book.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }
}
