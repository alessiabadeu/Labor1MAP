import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void displayStrings(ArrayList<String> strings){
        for(String string: strings){
            System.out.println(string);
        }
    }

    public void displayBooksPrice (ArrayList<Book> bookList){
        for(Book book: bookList){
            System.out.println(book.getTitle()+" -> "+book.getPrice()+" Euro");
        }
    }
    public ArrayList<String> BooksOfAuthor (String author){
        ArrayList<String> titles = new ArrayList<String>();
        for(Book book: books){
            if(book.getAuthor().equals(author)){
                titles.add(book.getTitle());
            }
        }
        return titles;
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
}