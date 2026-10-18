import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void displayStrings(ArrayList<String> strings){
        for(String string: strings){
            System.out.println(string);
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
}