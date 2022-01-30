package Entity;

public class Customer extends User {
    private String address;
    private Long balance;


    public Customer(String fullName, String nationalId, String password, TypeUser typeUser,String address,Long balance) {
        super(fullName, nationalId, password, typeUser);
        this.address = address;
        this.balance = balance;
    }

    public Customer(int id, String fullName, String nationalId, String password, TypeUser typeUser,String address,Long balance) {
        super(id, fullName, nationalId, password, typeUser);
        this.address = address;
        this.balance = balance;
    }
}