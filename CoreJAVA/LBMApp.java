import java.util.List;
import java.util.Scanner;

public class LBMApp {
    private final Scanner scanner=new Scanner(System.in);
    private final userService userService=new userService();
    private final bookService bookService=new bookService();
    private final AdminService adminService=new AdminService();

    public static void main(String[] args) {
        new LBMApp().start();
    }
    public void start(){
        System.out.println("Welcome to Sanket Library");
        while(true){
            if(!userService.isLoggedIn()){
                System.out.println("1.Register ");
                System.out.println("2.Login");
                System.out.println("3.exit");
                System.out.println("Enter Choice :");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1->register();
                    case 2->login();
                    case 3->exitApp();
                    default-> System.out.println("invalid choice");
                }

            }
            else {
                showUserService();
            }
        }
    }
    public void register(){
        System.out.print("Enter Username :");
        String username=scanner.next();
        System.out.print("Enter Password :");
        String password=scanner.next();
        System.out.print("Enter full name :");
        scanner.nextLine();
        String fullname=scanner.nextLine();
        System.out.print("Enter contact :");
        String contact=scanner.next();

        userService.registerUser(username,password,fullname,contact);

    }
    public void login(){
        System.out.print("Enter Username :");
        String username=scanner.next();
        System.out.print("Enter Password :");
        String password=scanner.next();
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("8317")){
            adminService.login(username,password);
            showAdminservice();
        }else {
            userService.login(username, password);
        }
    }
    public void exitApp(){
        System.out.println("Thank you for visiting Our Library");
        System.exit(0);
    }
    public void showUserService(){
        while(userService.isLoggedIn()){
            System.out.println("---->User Menu ------>");
            System.out.println("1.Search Book :");
            System.out.println("2.Borrow Book");
            System.out.println("3.View My Borrowed book");
            System.out.println("4.Return book");
            System.out.println("5.View All Book Available");
            System.out.println("6.logout :");
            System.out.println("Enter choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1->searchBook();
                case 2->borrowBook();
                case 3->viewMyBook();
                case 4->returnBook();
                case 5->bookService.ListAllBook();
                case 6->userService.logoutUser();
                default -> System.out.println("Invalid Choice");

            }

        }
    }
    private void searchBook(){
        System.out.println("Enter Book Id :");
        int id=scanner.nextInt();
        List<Book> books= bookService.searchBook(id);
        if (books.isEmpty()){
            System.out.println("Sorry this book is not available");
            return;
        }
        System.out.println("Books found");
        for (Book book:books){
            System.out.println(book);
        }
        System.out.println("Do you want to borrow  this book (yes/no)?");
        String choice= scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            Receipt receipt=bookService.borrowBooked(userService.getCurrentUser(),id);
            if (receipt!=null){
                System.out.println("successfully borrowed");
                System.out.println(receipt);
            }
        }else{
            System.out.println("Returning to user menu");
        }
    }
    public void borrowBook(){
        System.out.println("Enter book id");
        int id=scanner.nextInt();
        Receipt receipt=bookService.borrowBooked(userService.getCurrentUser(),id);
        if (receipt!=null){
            System.out.println("successfully borrowed");
            System.out.println(receipt);
        }
    }
    public void viewMyBook(){
        List<Receipt> receiptbyuser=bookService.getReceiptByUser(userService.getCurrentUser());
        if (receiptbyuser.isEmpty()){
            System.out.println("No book borrowed yet");
        }else {
            System.out.println("your ticket");
            for (Receipt receipt:receiptbyuser){
                System.out.println(receipt);
            }
        }
    }
    public void returnBook(){
        System.out.println("Enter Receipt Id:");
        int id=scanner.nextInt();
        bookService.returnBooked(userService.getCurrentUser(),id);
    }
    public void showAdminservice(){
        while(adminService.isLoggedIn()){
            System.out.println("---->Admin Menu ------>");
            System.out.println("1.Add book :");
            System.out.println("2.List of all book :");
            System.out.println("3.logout :");
            System.out.println("Enter choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1->addBook();
                case 2->bookService.ListAllBook();
                case 3->adminService.logoutAdmin();
                default -> System.out.println("Invalid Choice");

            }


        }
    }
    public void addBook(){
        System.out.println("Enter book name :");
        String name= scanner.next();
        System.out.println("Enter book id:");
        int id=scanner.nextInt();
        System.out.println("Enter Author name:");
        String author=scanner.next();
        System.out.println("Publishing Year:");
        int year=scanner.nextInt();
        System.out.println("Total books");
        int totalBook=scanner.nextInt();
        adminService.addBook(name,id,author,year,totalBook);

    }



}
