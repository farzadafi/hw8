package Manager;

import Entity.Admin;
import Entity.Customer;
import Entity.TypeUser;
import Service.CustomerService;
import Service.LoginService;

import java.util.Scanner;

public class CustomerManager {
    private Scanner input = new Scanner(System.in);
    private String fullName,nationalId,password,address;
    private Utility utility = new Utility();
    private LoginService loginService = new LoginService();
    private CustomerService customerService = new CustomerService();


    public void addCustomer(){
        fullName= utility.setFullName();
        while(true){
            nationalId = utility.setNationalId();
            if(loginService.returnUser(nationalId) == null)
                break;
            else
                System.out.println("this national Id is used before!");
        }
        password = utility.setPassword();
        System.out.print("Enter your address:");
        address = input.nextLine();
        Customer customer = new Customer(fullName,nationalId,password, TypeUser.CUSTOMER,address,50000d);
        if(customerService.add(customer) != 0 ){
            System.out.println(fullName + " successful added!");
        }
        else
            System.out.println("Something is wrong!");
    }
}
