package service;

import Config.DAO;
import entity.Vehicle;
import entity.customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    public void addVehicle(Vehicle vehicle) throws SQLException {
        Connection conn= DAO.getConnection();
        PreparedStatement ps= conn.prepareStatement("INSERT INTO Vehicle( vehicle_id,vehicle_model,date) values(?,?,?)");
        ps.setInt(1,vehicle.getVeh_id());
        ps.setInt(2,vehicle.getVeh_model());
        ps.setDate(3, Date.valueOf(vehicle.getDate()));
        int update=ps.executeUpdate();
        System.out.println("Vehicle add Successfully");
        ps.close();
        conn.close();
    }
    public List<Vehicle> getAllCustomers() throws SQLException
    {
        List<Vehicle> list = new ArrayList<>();
        Connection conn = DAO.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("SELECT * from Vehicle");
        while(rs.next())
        {
            list.add(new Vehicle(rs.getInt("vehicle_model")));
        }
        return list;
    }
}
