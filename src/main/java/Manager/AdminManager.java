package Manager;

import Entity.Admin;
import Entity.Category;
import Entity.TypeUser;
import Service.AdminService;
import Service.CategoryService;
import Service.LoginService;

public class AdminManager {
    private AdminService adminService = new AdminService();
    private String fullName,nationalId,password,categoryName;
    private Utility utility = new Utility();
    private LoginService loginService = new LoginService();
    private CategoryService categoryService = new CategoryService();

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
}
