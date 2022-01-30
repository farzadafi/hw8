import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private int command;

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

}//while
