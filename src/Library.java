import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void remove(Book book){
        if(books.contains(book)){
            books.remove(book);
        }
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void displayTitles(ArrayList<Book> bookList){
        for(Book book: bookList){
            System.out.println(book.getTitle());
        }
    }

    public void displayBooksPages(ArrayList<Book> bookList){
        for(Book book: bookList){
            System.out.println(book.getTitle()+" -> "+book.getNumberPages()+" Seiten");
        }
    }

    public void displayBooksPrice (ArrayList<Book> bookList){
        for(Book book: bookList){
            System.out.println(book.getTitle()+" -> "+book.getPrice()+" Euro");
        }
    }

    public ArrayList<Book> BooksOfAuthor (String author){
        ArrayList<Book> filteredBooks = new ArrayList<Book>();
        for(Book book: books){
            if(book.getAuthor().equals(author)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public double averagePages(){
        if(books.isEmpty()){
            return 0;
        }

        int sumPages = 0;
        for(Book book: books){
            sumPages+=book.getNumberPages();
        }
        return (double) sumPages/books.size();
    }

    public ArrayList<Book> booksUnderPrice(double maxPrice){
        ArrayList<Book> filteredBooks = new ArrayList<Book>();
        for(Book book: books){
            if(book.getPrice() <= maxPrice){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}