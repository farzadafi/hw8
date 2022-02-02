package Manager;

import Entity.*;
import Service.*;

import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private Scanner input = new Scanner(System.in);
    private String fullName,nationalId,password,address;
    private Utility utility = new Utility();
    private LoginService loginService = new LoginService();
    private CustomerService customerService = new CustomerService();
    private CategoryService categoryService = new CategoryService();
    private ProductService productService = new ProductService();
    private CustomerBasketService customerBasketService = new CustomerBasketService();


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

    public void editCustomer(int id){
        fullName = utility.setFullName();
        password = utility.setPassword();
        System.out.print("Enter your new address:");
        address = input.nextLine();
        Customer customer = new Customer(id,fullName,null,password,null,address,null);
        if(customerService.update(customer) != 0 ){
            System.out.println(fullName + " successful updated!");
        }
    }

    public void addProduct(int id){
        List<Category> categoryList = categoryService.showCategory(0);
        if(categoryList == null){
            System.out.println("Unfortunately We dont have any product for sale!");
            return;
        }
        int[] array = utility.returnIdCategory(categoryList);
        for (Category cat:categoryList
        ) {
            System.out.println(cat.toString());
        }
        int idCategory = utility.setId(array);
        if(idCategory == 0 ){
            return;
        }
        categoryList = categoryService.showCategory(idCategory);
        if(categoryList == null){
            System.out.println("Unfortunately We dont have any product in this category!");
            return;
        }
        System.out.println("This brand we have:");
        for (Category cat:categoryList
        ) {
            System.out.println(cat.toString());
        }
        array = utility.returnIdCategory(categoryList);
        int idBrand = utility.setId(array);
        List<Product> productList = productService.showProductForCustomer(idCategory,idBrand);
        if(productList == null){
            System.out.println("Unfortunately We dont have any product in this brand!");
            return;
        }
        System.out.println("We have this product in this brand:");
        for (Product pro:productList
        ) {
            System.out.println(pro.toString());
        }
        array = utility.returnIdProduct(productList);
        int idProduct = utility.setId(array);
        if(idProduct == 0 )
            return;
        int number = utility.setNumberProduct(idProduct,productList);
        if(number == -1 ){
            System.out.println("SomeThing is wrong!");
            return;
        }
        int numberCustomerBuy = utility.setNumberProduct("product you want to buy:");
        if(numberCustomerBuy > number ){
            System.out.println("We dont have " + numberCustomerBuy + " number from this product!");
            return;
        }
        Double price = utility.returnPriceProduct(idProduct,productList);
        CustomerBasket customerBasket = new CustomerBasket(id,idProduct,numberCustomerBuy,numberCustomerBuy*price);
        if(customerBasketService.add(customerBasket) != 0 )
            System.out.println(numberCustomerBuy + " number from this product with " + numberCustomerBuy*price + " price added to your basket!");
        else
            System.out.println("Something is wrong!");
    }

    public void removeProduct(int id){
        List<CustomerBasket> customerBasketList = customerBasketService.customerBasketById(id);
        if(customerBasketList == null){
            System.out.println("Unfortunately We dont have any product for sale!");
            return;
        }
        int[] array = utility.returnIdCustomerBasket(customerBasketList);
        for (CustomerBasket cat:customerBasketList
        ) {
            System.out.println(cat.toString());
        }
        int idCustomerBasket = utility.setId(array);
        if(idCustomerBasket == 0 ){
            return;
        }
        if(customerBasketService.delete(idCustomerBasket) != 0 )
            System.out.println("This product successful removed!");
        else
            System.out.println("Something is wring!");
    }




















}
