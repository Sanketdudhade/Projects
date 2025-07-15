package service;

import Config.DAO;
import entity.customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private customer currentUser=null;

    public void addCustomer(customer cust) throws SQLException
    {
        Connection conn = DAO.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO customer" +
                        " (name,phone) VALUES (?,?)");
        ps.setString(1,cust.getName());
        ps.setString(2,cust.getPhone());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<customer> getAllCustomers() throws SQLException
    {
        List<customer> list = new ArrayList<>();
        Connection conn = DAO.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("SELECT * from customer");
        while(rs.next())
        {
            list.add(new customer(rs.getNString("name"),rs.getNString("name") ));
        }
        return list;
    }

    public customer getCustomersBasesOnNum(String number) throws SQLException
    {

        customer customer=new customer();
        Connection conn = DAO.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("SELECT * from customer where phone = "+number);
        while(rs.next())
        {
            customer = new customer(rs.getNString("name"),rs.getNString("name") )
            ;
        }
        return customer;
    }
    public boolean isLoggedin(){
        return currentUser!=null;

    }

}