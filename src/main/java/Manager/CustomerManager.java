package Manager;

import Entity.*;
import Service.*;

import java.sql.Date;
import java.time.LocalDate;
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
    private SaleProductService saleProductService = new SaleProductService();


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

    public void addBudget(int id){
        Double budget = utility.setPriceProduct("withdraw");
        if(customerService.addBudget(id,budget) != 0 )
            System.out.println("This operation successful!");
        else
            System.out.println("Something is wrong!");
    }

    public void viewMyBasket(int id){
        List<CustomerBasket> customerBasketList = customerBasketService.customerBasketById(id);
        if(customerBasketList == null){
            System.out.println("Unfortunately We dont have any product for sale!");
            return;
        }
        for (CustomerBasket cat:customerBasketList
        ) {
            System.out.println(cat.toString());
        }
    }

    public void finalPurchase(int id){
        List<CustomerBasket> customerBasketList = customerBasketService.customerBasketById(id);
        if(customerBasketList == null){
            System.out.println("Unfortunately We dont have any product for sale!");
            return;
        }
        Double calcPriceProduct = 0d;
        for (CustomerBasket cat:customerBasketList
             ) {
            calcPriceProduct += cat.getTotalPrice();
        }
        Double customerBudget = customerService.returnBudget(id);
        if(calcPriceProduct > customerBudget ){
            System.out.println("You dont have enough budget!");
            return;
        }
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        for (CustomerBasket cat:customerBasketList
             ) {
            if(cat.getNumber() > productService.returnNumberProduct(cat.getProductId()))
                System.out.println("We dont have enough " + cat.getId() + " !");
            else{
                SaleProduct saleProduct = new SaleProduct(cat.getCustomerId(),cat.getProductId(),cat.getNumber(),cat.getTotalPrice(),date);
                saleProductService.add(saleProduct);
                productService.minesNumberProduct(cat.getProductId(),cat.getNumber());
                customerService.addBudget(id,-cat.getTotalPrice());
                customerBasketService.delete(customerBasketService.findIdBy(cat.getCustomerId(),cat.getProductId(), cat.getNumber()));
            }
        }
    }




















}
