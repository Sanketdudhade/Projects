import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bookService {
     List<Book> booklist=new ArrayList<>();
    private  List<Receipt> receiptList=new ArrayList<>();
    public bookService(){
        booklist.add(new Book("स्त्रिया" , 101, "Kristin Hannah", 2024, 30));
        booklist.add(new Book("The Women", 001, "Kristin Hannah", 2024, 40));
        booklist.add(new Book("Fourth Wing", 102, "Rebecca Yarros", 2023, 50));
        booklist.add(new Book("Iron Flame", 103, "Rebecca Yarros", 2023, 10));
        booklist.add(new Book("The Housemaid", 104, "Freida McFadden", 2022, 14));
        booklist.add(new Book("It Ends with Us", 105, "Colleen Hoover", 2016, 13));
        booklist.add(new Book("Atomic Habits", 106, "James Clear", 2018, 100));
        booklist.add(new Book("A Court of Thorns and Roses", 107, "Sarah J. Maas", 2015, 10));
        booklist.add(new Book("Funny Story", 108, "Emily Henry", 2024, 11));
        booklist.add(new Book("We Solve Murders", 109, "Richard Osman", 2024, 130));
        booklist.add(new Book("Kairos", 110, "Jenny Erpenbeck", 2024, 90));
        booklist.add(new Book("The Anxious Generation", 111, "Jonathan Haidt", 2024, 70));
        booklist.add(new Book("The Book of Bill", 112, "Alex Hirsch", 2024, 96));
        booklist.add(new Book("Katabasis", 113, "R.F. Kuang", 2025, 50));
        booklist.add(new Book("Sunrise on the Reaping", 114, "Suzanne Collins", 2025, 1000));
        booklist.add(new Book("The Magnolia That Bloomed Unseen", 115, "Ray Smith", 2025, 10));


    }
    public List<Book> searchBook(int bookId){
        List<Book> res=new ArrayList<>();
        for (Book book:booklist){
            if(book.getBookId()==bookId ){
                res.add(book);
            }

        }
        return res;
    }
    public Receipt borrowBooked(User user,int bookId){
        for (Book book:booklist){
            if (book.getBookId()==bookId){
                if (book.getAvailableBook()!=0){
                    Receipt receipt=new Receipt(user,book,1);
                    receiptList.add(receipt);
                    return receipt;
                }else {
                    System.out.println("This book currently unavailable");
                    return null;
                }
            }
        }
        System.out.println("Book not found");
        return null;

    }

    public List<Receipt> getReceiptByUser(User user) {
        List<Receipt> res=new ArrayList<>();
        for (Receipt receipt:receiptList){
            if (receipt.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                res.add(receipt);
            }

        }
        return res;
    }
    public boolean returnBooked(User user,int receiptId){
        Iterator<Receipt> iterator=receiptList.listIterator();
        while (iterator.hasNext()){
            Receipt receipt=iterator.next();
            if (receipt.getReceiptId()==receiptId && receipt.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                Book book=receipt.getBook();
                book.returnBook(user,receipt);
                iterator.remove();
                System.out.println("ReceiptId :"+receiptId+" Return successfully");
                return true;
            }
        }
        System.out.println("Receipt not Found");
        return false;

    }
    public void ListAllBook(){
        System.out.println("List if Alll Book Available");
        for (Book book:booklist){
            System.out.println(book);
        }
    }
}
