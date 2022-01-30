package Entity;

public class Product {
    private int id;
    private int adminId;
    private String name;
    private int number;
    private Double price;

    public Product(int id, int adminId, String name, int number, Double price) {
        this.id = id;
        this.adminId = adminId;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public Product(int adminId, String name, int number, Double price) {
        this.adminId = adminId;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
