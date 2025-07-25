package entity;

public class customer {
    private int id;
    private String name;
    private String phone;

    public customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "customer [" +
                "id=" + id +
                "  name= " + name  +
                "  phone= " + phone  +
                " ] ";
    }
}
