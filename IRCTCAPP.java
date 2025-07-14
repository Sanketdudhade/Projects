import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {
    private final Scanner scanner=new Scanner(System.in);
    private  final UserService userService=new UserService();
    private  final BookingService bookingService=new BookingService();
    public static void main(String[] args) {
        new IRCTCAPP().start();

    }
    public void start(){
        System.out.println("<--------Welcome to IRCTC app------>");
        while(true){
            if (!userService.isLoggedIn()){
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
        userService.loginUser(username,password);
    }
    public void exitApp(){
        System.out.println("Thank you for visiting IRCTC app");
        System.exit(0);
    }

    private void showUserService(){
        while(userService.isLoggedIn()){
            System.out.println("---->User Menu ------>");
            System.out.println("1.Search Train :");
            System.out.println("2.Booked Ticked");
            System.out.println("3.View My Tickets");
            System.out.println("4.Cancel Tickets");
            System.out.println("5.View All Trains");
            System.out.println("6.logout :");
            System.out.println("Enter choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1 ->searchTrain();
                case 2->bookedTrain();
                case 3->viewMyTickect();
                case 4->cancelTicket();
                case 5->bookingService.ListallTrain();
                case 6->userService.logOutUser();
                default -> System.out.println("Invalid Choice");

            }

        }
    }
    private void searchTrain(){
        System.out.println("Enter Source station");
        String source=scanner.next();
        System.out.println("Enter Destination station");
        String destination=scanner.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if (trains.isEmpty()){
            System.out.println(" No Train found between"+source+" and "+destination);
            return;
        }
        System.out.println("Trains Found");
        for (Train train:trains){
            System.out.println(train);
        }
        System.out.println("Do you want to book ticket (yes/no)?");
        String choice= scanner.next();
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("Enter train id :");
            int id= scanner.nextInt();
            System.out.println("Enter of seat to booked");
            int seat= scanner.nextInt();
            Ticket ticket=bookingService.bookTicked(userService.getCurrentUser(),id,seat);
            if(ticket!=null){
                System.out.println("Booking Successfull");
                System.out.println(ticket);
            }
        }
        else {
            System.out.println("Returning to user menu");
        }

    }
    private void bookedTrain(){
        System.out.println("Enter Source station");
        String source=scanner.next();
        System.out.println("Enter Destination station");
        String destination=scanner.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if (trains.isEmpty()){
            System.out.println(" No Trains available for"+source+" and "+destination);
            return;
        }
        System.out.println("Trains Found");
        for (Train train:trains){
            System.out.println(train);
        }
        System.out.println("Enter train id :");
        int id= scanner.nextInt();
        System.out.println("Enter of seat to booked");
        int seat= scanner.nextInt();
        Ticket ticket=bookingService.bookTicked(userService.getCurrentUser(),id,seat);
        if(ticket!=null){
            System.out.println("Booking Successfull");
            System.out.println(ticket);
        }
    }
    private void viewMyTickect(){
        List<Ticket> ticketbyuser=bookingService.getTicketByUser(userService.getCurrentUser());
        if (ticketbyuser.isEmpty()){
            System.out.println("No ticket booked yet");
        }else{
            System.out.println("Your Ticket");
            for (Ticket ticket:ticketbyuser){
                System.out.println(ticket);
            }
        }
    }
    private void cancelTicket(){
        System.out.println("Enter ticket id :");
        int ticketid= scanner.nextInt();
        bookingService.cancleTicket(ticketid,userService.getCurrentUser());

    }
}
