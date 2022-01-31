package Manager;

import Entity.Category;
import Manager.Exception.InvalidName;
import Manager.Exception.InvalidNationalId;
import Manager.Exception.InvalidPassword;

import java.util.List;
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

    public int setId(int[] array){
        int id;
        System.out.print("Enter your brand id:");
        try {
            id = input.nextInt();
            input.nextLine();
        }catch (Exception exception){
            input.nextLine();
            System.out.println("just Enter number Professor!");
            return 0;
        }
        boolean isContain = false;
        for (int number:array
        ) {
            if(number == id ) {
                isContain = true;
                break;
            }
        }
        if(!isContain) {
            System.out.println("This id is not find!");
            return 0;
        }
        else
            return id;
    }

    //::::>
    public int[] returnIdCategory(List<Category> categoryList){
        int[] arrayInt = new int[50];
        int index = 0;
        for (Category cat:categoryList
        ) {
            Category cat1 = new Category();
            cat1 = cat;
            arrayInt[index] = cat.getId();
            index++;
        }
        return arrayInt;
    }



}
