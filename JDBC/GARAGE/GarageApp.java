import Config.DAO;
import entity.Vehicle;
import entity.customer;
import entity.invoice;
import service.BillingService;
import service.CustomerService;
import service.InvoiceService;
import service.VehicleService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GarageApp {
    public CustomerService customerService = new CustomerService();
    public InvoiceService invoiceService=new InvoiceService();
    public VehicleService vehicleService=new VehicleService();
    public BillingService billingService=new BillingService();
    private  final Scanner sc=new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        new GarageApp().start();

    }

    public void start() throws SQLException {
        System.out.println("Welcome to Sai Garage");
        while (true){
            System.out.println("1.Register Customer");
            System.out.println("2.Add Vehicle to Garage");
            System.out.println("3.Invoice :");
            System.out.println("4.Bill");
            System.out.println("5.All Invoices");
            System.out.println("6.Search Customer");
            System.out.println("7.exitApp");
            System.out.println("Enter choice:");
            int choice=sc.nextInt();
            switch(choice){
                case 1->register();
                case 2->addVehicle();
                case 3->invoice();
                case 4->bill();
                case 5->allBill();
                case 6->searchCustomer();
                case 7->exitApp();
                default -> System.out.println("Invalid choice");

            }
        }

    }
    public  void register() throws SQLException {
        System.out.println("Enter name :");
        String name=sc.next();
        System.out.println("Enter PHone :");
        String phone=sc.next();
        customerService.addCustomer(new customer(name,phone));
    }
    public void addVehicle() throws SQLException {
        System.out.println("Enter Vehicle model :");
        int model=sc.nextInt();
        vehicleService.addVehicle(new Vehicle(model));
    }
    public void selectService() throws SQLException {
        Connection conn= DAO.getConnection();
        Statement st=conn.createStatement();
        String query="SELECT * FROM Service";
        ResultSet rs=st.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getInt("service_id")+" | "
                    +rs.getString("service_name")+" | "+
                    rs.getInt("cost")
            );
        }

    }
    public void invoice() throws SQLException {
        System.out.println("Enter customer id:");
        int id= sc.nextInt();
        System.out.println("Enter vehicle id:");
        int veh= sc.nextInt();
        System.out.println("Choose Service :");
        selectService();
        int service= sc.nextInt();
        invoiceService.addInvoice(new invoice(id,veh,service));
        System.out.println("invoice added successfully");


    }
    public void bill() throws SQLException {
        System.out.println("Enter customer id:");
        int id= sc.nextInt();
        System.out.println("Enter vehicle id:");
        int veh= sc.nextInt();
        System.out.println("Choose Service :");
        selectService();
        List<Integer> service= Collections.singletonList(sc.nextInt());
        billingService.createInvoice(id,veh,service);

    }
    public void allBill() throws SQLException {
        billingService.showAllInvoices();
    }
    public void searchCustomer() throws SQLException {
        System.out.println("Enter phone number:");
        String phone=sc.next();
         customer cust=customerService.getCustomersBasesOnNum(phone);
        System.out.println(cust);

    }

    public void exitApp(){
        System.out.println("Thank you for visiting Our Shop :");
        System.exit(0);
    }



}
