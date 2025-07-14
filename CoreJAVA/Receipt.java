import java.time.LocalDate;

public class Receipt {
    private static int counter=1000;
    private int receiptId;
    private User user;
    private Book book;
    private int borrowBook;
    LocalDate date=LocalDate.now();

    public Receipt( User user, Book book, int borrowBook) {
        this.receiptId = counter++;
        this.user = user;
        this.book = book;
        this.borrowBook = borrowBook;
    }

    public int getCounter() {
        return counter;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBorrowBook() {
        return borrowBook;
    }

    public void setBorrowBook(int borrowBook) {
        this.borrowBook = borrowBook;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return receiptId+" | BookId"+book.getBookId()+" | Bookname :"+book.getBookName()
                +" | Author:"+book.getAuthor()+" | Borrow count:"+borrowBook+
                " | Borrowed by :"+user.getFullname()+"Date :"+date;
    }
}
