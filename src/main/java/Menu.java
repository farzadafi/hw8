import Manager.AdminManager;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private int command;
    private AdminManager adminManager = new AdminManager();

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
                //cinemaManager.registerCinema();
                break;

            case 3:
                System.out.println("Good luck!");
                return;

            default:
                System.out.println("You enter a wrong number!");
        }
    }


}//while
