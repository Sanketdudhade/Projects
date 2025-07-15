package entity;

import java.time.LocalDate;

public class Vehicle {
     private  int veh_id;
     private  int veh_model;
    LocalDate date=LocalDate.now();

    public Vehicle( int veh_model) {

        this.veh_model = veh_model;
    }
    public Vehicle(){

    }

    public int getVeh_id() {
        return veh_id;
    }

    public void setVeh_id(int veh_id) {
        this.veh_id = veh_id;
    }

    public int getVeh_model() {
        return veh_model;
    }

    public void setVeh_model(int veh_model) {
        this.veh_model = veh_model;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vehicle [" +
                "veh_id=" + veh_id +
                ", veh_model=" + veh_model +
                ", date=" + date +
                ']';
    }
}
