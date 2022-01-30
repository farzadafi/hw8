package Manager;

import Manager.Exception.InvalidName;
import Manager.Exception.InvalidNationalId;

import java.util.Scanner;

public class Utility {
    private Scanner input = new Scanner(System.in);
    private String fullName,nationalId;
    private InvalidName invalidName = new InvalidName();
    private InvalidNationalId invalidNationalId = new InvalidNationalId();


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


}
