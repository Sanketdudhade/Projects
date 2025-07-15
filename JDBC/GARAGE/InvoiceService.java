package service;

import Config.DAO;
import entity.invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    public void addInvoice(invoice invoice) throws SQLException{
        Connection conn= DAO.getConnection();
        PreparedStatement ps= conn.prepareStatement("INSERT INTO invoice(customer_id,vehicle_id,service_id) values (?,?,?)");

        ps.setInt(1,invoice.getCutomerId());
        ps.setInt(2,invoice.getVehicleId());
        ps.setInt(3,invoice.getServiceId());
        ps.executeUpdate();
    }
    public List<invoice> getAllInvoices() throws SQLException
    {
        List<invoice> list = new ArrayList<>();
        Connection conn = DAO.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("SELECT * from invoice");
        while(rs.next())
        {
            list.add(new invoice(
                    rs.getInt("customer_id"),
                    rs.getInt("vehicle_id"),rs.getInt("service_id")));
        }
        return list;
    }
}
