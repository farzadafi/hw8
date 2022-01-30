package Manager;

import Manager.Exception.InvalidName;

import java.util.Scanner;

public class Utility {
    private Scanner input = new Scanner(System.in);
    private String fullName;
    private InvalidName invalidName = new InvalidName();


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

}
