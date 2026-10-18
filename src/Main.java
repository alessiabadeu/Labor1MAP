public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert Martin", 45.00, 464);
        Book book2 = new Book("1984", "George Orwell", 18.00, 328);
        Book book3 = new Book("Animal Farm", "George Orwell", 11.99, 112);
        Book book4 = new Book("Java Basics", "Max Muller", 35.00, 520);
        Book book5 = new Book("The Hobbit", "J.R.R Tolkien", 27.99, 310);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
    }
}