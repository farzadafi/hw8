package Manager;

import Entity.Admin;
import Entity.Category;
import Entity.TypeUser;
import Service.AdminService;
import Service.CategoryService;
import Service.LoginService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdminManager {
    private AdminService adminService = new AdminService();
    private String fullName,nationalId,password,categoryName,brandName;
    private Utility utility = new Utility();
    private LoginService loginService = new LoginService();
    private CategoryService categoryService = new CategoryService();
    private Scanner input = new Scanner(System.in);

    //::::>
    public void addManager(){
        fullName= utility.setFullName();
        while(true){
            nationalId = utility.setNationalId();
            if(loginService.returnUser(nationalId) == null)
                break;
            else
                System.out.println("this national Id is used before!");
        }
        password = utility.setPassword();
        Admin admin = new Admin(fullName,nationalId,password,TypeUser.ADMIN);
        if(adminService.add(admin) != 0 ){
            System.out.println(fullName + " successful added!");
        }
    }

    //::::>
    public void editManager(int id){
        fullName = utility.setFullName();
        password = utility.setPassword();
        Admin admin = new Admin(id,fullName,null,password,null);
        if(adminService.update(admin) != 0 ){
            System.out.println(fullName + " successful updated!");
        }
    }

    public void addCategory(){
        categoryName = utility.setCategoryName();
        Category category = new Category(0,categoryName);
        if(categoryService.add(category) != 0 )
            System.out.println(categoryName + " successful added!");
        else
            System.out.println("Something is wrong");
    }

    public void addBrand(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList == null){
            System.out.println("You first have define category!");
            return;
        }
        int[] array = utility.returnIdCategory(categoryList);
        for (Category cat:categoryList
             ) {
            System.out.println(cat.toString());
        }
        int id = utility.setId(array);
        if(id == 0 ){
            return;
        }
        System.out.print("Enter name of Brand:");
        brandName = input.nextLine();
        Category category = new Category(id,brandName);
        if(categoryService.add(category) != 0 )
            System.out.println(brandName + " successful added!");
        }






















}
