import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = generateLibrary();
        Menu(library);
    }

    public static Library generateLibrary(){
        Book book1 = new Book("Clean Code", "Robert Martin", 45.00, 464);
        Book book2 = new Book("1984", "George Orwell", 18.00, 328);
        Book book3 = new Book("Animal Farm", "George Orwell", 12.00, 112);
        Book book4 = new Book("Java Basics", "Max Muller", 35.00, 520);
        Book book5 = new Book("The Hobbit", "J.R.R Tolkien", 28.00, 310);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        return library;
    }

    public static double getDouble(Scanner scanner){
        if(scanner.hasNextDouble()){
           return scanner.nextDouble();
        }
        scanner.nextLine();
        return -1;
    }

    public static int getInt(Scanner scanner){
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }
        scanner.nextLine();
        return -1;
    }

    public static void displayMenu(){
        System.out.println("1. Books of author");
        System.out.println("2. Average");
        System.out.println("3. Books with price limit");
        System.out.println("4. The most expensive book");
        System.out.println("5. Books with a certain amount of pages");
        System.out.println("6. Two books for a budget");
        System.out.println("0. Exit");
    }

    public static void Menu (Library library){
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while(option!=0){
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    System.out.println("Author: ");
                    String author = scanner.nextLine();
                    library.displayTitles(library.BooksOfAuthor(author));
                    break;
                case 2:
                    library.displayBooksPages(library.getBooks());
                    System.out.println(library.averagePages());
                    break;
                case 3:
                    System.out.print("Maximaler Preis: ");
                    double maxPrice = getDouble(scanner);
                    if(maxPrice!=-1){
                        library.displayBooksPrice(library.booksUnderPrice(maxPrice));
                    }
                    else {
                        System.out.println("Nicht gultige Input");
                    }
                    break;
                case 4:
                    library.displayBooksPrice(library.getBooks());
                    System.out.println("Teureste Buch: ");
                    System.out.println(library.mostExpensiveBook().getTitle());
                    break;
                case 5:
                    System.out.println("Mindestanzahl: ");
                    int minPages = getInt(scanner);
                    if(minPages!=-1){
                        library.displayTitles(library.booksWithMinPages(minPages));
                    }
                    else {
                        System.out.println("Nicht gultige Input");
                    }
                    break;
                case 6:
                    System.out.println("Budget: ");
                    double budget = getDouble(scanner);
                    if(budget!=-1){
                        ArrayList<Book> books = library.twoBooksWithinBudget(budget);
                        if(books.size() == 2) {
                            System.out.println(books.getFirst().getTitle() + " + " + books.get(1).getTitle());
                            double price = books.getFirst().getPrice() + books.get(1).getPrice();
                            System.out.println("Gesamtpreis: " + price + " Euro");
                        }
                        else{
                            System.out.println("Es gibt keine solche Bucher");
                        }
                    }
                    else {
                        System.out.println("Nicht gultige Input");
                    }
                    break;
                case 0:
                    break;
            }
        }
    }
}