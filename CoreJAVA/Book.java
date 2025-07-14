import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
    private String bookName;
    private int bookId;
    private String Author;
    private int publishYear;
    private int totalBook;
    private int availableBook;
    LocalDate currentDate=LocalDate.now();

    public Book(String bookName, int bookId, String author, int publishYear, int totalBook) {
        this.bookName = bookName;
        this.bookId = bookId;
        Author = author;
        this.publishYear = publishYear;
        this.totalBook = totalBook;
        this.availableBook = totalBook;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    public int getAvailableBook() {
        return availableBook;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void setAvailableBook(int availableBook) {
        this.availableBook = availableBook;
    }
    public boolean borrowBook(){
        if (1<=availableBook){
            availableBook-=1;
            return true;
        }
        return  false;
    }
    public void returnBook(User user,Receipt r){
        int fine=0;
        availableBook-=1;
        int diff= Math.toIntExact(ChronoUnit.DAYS.between(currentDate, r.getDate()));
        if (diff > 10){
            fine=diff*5;
        }
        if (fine>0){
            System.out.println("Pay fine on Office section"+fine);
        }


    }



    @Override
    public String toString() {
        return bookId+" | "+bookName+" | "+Author+" | "+publishYear+" | "+
                "Available books :"+availableBook;
    }
}
