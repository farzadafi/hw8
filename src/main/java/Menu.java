import Entity.User;
import Manager.AdminManager;
import Manager.CustomerManager;
import Service.LoginService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private boolean isTrue = true;
    private int command;
    private String username,password;
    private AdminManager adminManager = new AdminManager();
    private CustomerManager customerManager = new CustomerManager();
    private LoginService loginService = new LoginService();

    //::::>
    public int publicMenu(){
        System.out.println("***WELCOME***");
        System.out.println("1-signIn(Enter)");
        System.out.println("2-signUp(Register)");
        System.out.println("3-Exit");
        System.out.print("Please select a number:");
        while(true) {
            try {
                command = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException exception) {
                input.nextLine();
                System.out.print("Enter a number:");
            }
        }
        switch(command){
            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 3;

            default:
                return 0;
        }
    }

    //:::::>
    public void RegisterMenu() throws SQLException {
        System.out.println("Who are you?");
        System.out.println("1-Admin.");
        System.out.println("2-Customer.");
        System.out.println("3-Cancel!");
        System.out.print("Please select a number:");
        try {
            command = input.nextInt();
        }catch (InputMismatchException exception){
            input.nextLine();
            System.out.println("You can just Enter number!");
            return;
        }
        input.nextLine();
        switch(command)
        {

            case 1:
                adminManager.addManager();
                break;

            case 2:
                customerManager.addCustomer();
                break;

            case 3:
                System.out.println("Good luck!");
                return;

            default:
                System.out.println("You enter a wrong number!");
        }
    }

    //::::>
    public void enterMenu() throws SQLException, ClassNotFoundException {
        System.out.print("Please enter your username:");
        username = input.nextLine();
        User user = loginService.returnUser(username);
        if(user == null){
            System.out.println("This user name not define before,Please sign up!");
            return;
        }
        System.out.print("Please enter your password:");
        password = input.nextLine();
        if(!password.equals(user.getPassword())){
            System.out.println("This password is wrong!");
            return;
        }
        if(String.valueOf(user.getTypeUser()).equals("ADMIN"))
            adminMenu(user.getId());
        else if(String.valueOf(user.getTypeUser()).equals("CUSTOMER"))
            customerMenu(user.getId());
        else
            System.out.println("It's very Strange!");
    }


    //::::>
    public void adminMenu(int id) throws SQLException {
        isTrue = true;
        while(isTrue) {
            System.out.println("*** Admin Menu ***");
            System.out.println("1-Edit my information.");
            System.out.println("2-Add category.");
            System.out.println("3-Add brand.");
            System.out.println("4-Add Product.");
            System.out.println("5-Add number to product.");
            System.out.println("6-Remove product.");
            System.out.println("7-Add off code.");
            System.out.println("8-View my sale.");
            System.out.println("10-Exit.");
            while(true) {
                try {
                    command = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException exception) {
                    input.nextLine();
                    System.out.print("Enter a number:");
                }
            }
            switch (command)
            {
                case 1:
                    adminManager.editManager(id);
                    break;

                case 2:

                    break;

                case 10:
                    System.out.println("Good luck!");
                    isTrue = false;
                    break;

                default:
                    System.out.println("you enter a wrong number!");
            }
        }
    }

    //::::>
    public void customerMenu(int id){
        System.out.println("customerMenu");
        System.out.println(id);
    }



}
