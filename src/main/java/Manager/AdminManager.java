package Manager;

import Entity.Admin;
import Entity.TypeUser;
import Service.AdminService;
import Service.LoginService;

public class AdminManager {
    private AdminService adminService = new AdminService();
    private String fullName,nationalId,password;
    private Utility utility = new Utility();
    private LoginService loginService = new LoginService();


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
}
