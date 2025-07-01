public class Book {
    private String id;
    private String title;
    private String authar;
    private boolean isBorrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() { isBorrowed = true; }
    public void returned() { isBorrowed = false; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (isBorrowed ? "Borrowed" : "Available");
    }

    public String toFileString() {
        return id + "," + title + "," + author + "," + isBorrowed;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        Book b = new Book(parts[0], parts[1], parts[2]);
        if (Boolean.parseBoolean(parts[3])) {
            b.borrow();
        }
        return b;
    }
}
