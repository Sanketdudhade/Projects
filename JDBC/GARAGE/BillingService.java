package service;

import entity.invoice;

import java.security.Provider;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingService {

    public InvoiceService invoiceService=new InvoiceService();

    public  void createInvoice(int customer_id, int vehicle_id, List<Integer> service_ids) throws SQLException {
        String sids="";
        for (int service_id:service_ids){
            sids+=service_id;
        }
        invoiceService.addInvoice( new invoice(customer_id,vehicle_id,Integer.parseInt(sids)));
        System.out.println("Invoice Created Successfully");

    }
    public void showAllInvoices() throws SQLException {
        List<invoice> invoices=invoiceService.getAllInvoices();
        for (invoice invoice:invoices){
            System.out.println(invoice);
        }
    }

}
