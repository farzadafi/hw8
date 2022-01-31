package Manager;

import Manager.Exception.InvalidName;
import Manager.Exception.InvalidNationalId;
import Manager.Exception.InvalidPassword;

import java.util.Scanner;

public class Utility {
    private Scanner input = new Scanner(System.in);
    private String fullName,nationalId,password,categoryName;
    private InvalidName invalidName = new InvalidName();
    private InvalidNationalId invalidNationalId = new InvalidNationalId();
    private InvalidPassword invalidPassword = new InvalidPassword();


    public String setFullName(){
        while(true){
            System.out.print("Enter name(just alpha):");
            try {
                fullName = input.nextLine();
                invalidName.checkName(fullName);
                break;
            }catch (InvalidName except){
                System.out.println(except.getMessage());
            }
        }
        return fullName;
    }

    public String setNationalId(){
        while(true){
            System.out.print("Enter National Id(just number):");
            try {
                nationalId = input.nextLine();
                invalidNationalId.nationalIdChecker(nationalId);
                break;
            }catch (InvalidNationalId except){
                System.out.println(except.getMessage());
            }
        }
        return nationalId;
    }

    public String setPassword(){
        while(true) {
            System.out.print("Enter your password:");
            try {
                password = input.nextLine();
                invalidPassword.passwordCheck(password);
                break;
            } catch (InvalidPassword except) {
                System.out.println(except.getMessage());
            }
        }
        return password;
    }

    public String setCategoryName(){
        while(true){
            System.out.print("Enter name(just alpha):");
            try {
                categoryName = input.nextLine();
                invalidName.checkName(categoryName);
                break;
            }catch (InvalidName except){
                System.out.println(except.getMessage());
            }
        }
        return categoryName;
    }



}
