import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void remove(Book book){
            books.remove(book);
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
        ArrayList<Book> filteredBooks = new ArrayList<>();
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
        ArrayList<Book> filteredBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getPrice() <= maxPrice){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public Book mostExpensiveBook(){
        if(books.isEmpty()){
            return null;
        }

        double maxPrice = 0;
        Book expensiveBook = books.getFirst();
        for(Book book: books){
           if(book.getPrice() > maxPrice){
               maxPrice = book.getPrice();
               expensiveBook = book;
           }
        }
        return expensiveBook;
    }

    public ArrayList<Book> booksWithMinPages (int minPages){
        ArrayList<Book> filteredBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getNumberPages() >= minPages){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public ArrayList<Book> twoBooksWithinBudget(double budget){
        double max = 0;
        double sum = 0;
        Book buyBook1 = null;
        Book buyBook2 = null;
        ArrayList<Book> result = new ArrayList<>();
        for(int index1 = 0; index1<books.size(); index1++){
            for(int index2 = index1+1; index2< books.size(); index2++ ){
                if(index1!=index2){
                    Book book1 = books.get(index1);
                    Book bool2 = books.get(index2);
                    sum = book1.getPrice()+bool2.getPrice();
                    if(sum <= budget && sum > max){
                        max = sum;
                        buyBook1 = book1;
                        buyBook2 = bool2;
                    }
                }
            }
        }
        if(buyBook1!=null){
            result.add(buyBook1);
            result.add(buyBook2);
        }
        return result;
    }
}