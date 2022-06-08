package ProductManage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValiDate {
    Scanner input = new Scanner(System.in);


    public int importInt(String a) {
        while (true) {
            try {
                System.out.println("Enter " + a);
                int b = Integer.parseInt(input.nextLine());
                return b;
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again by number");
                importInt(a);

            }
        }
    }

    public double importDouble(String a) {
        while (true) {
            try {
                System.out.println("Enter " + a);
                double b = Double.parseDouble(input.nextLine());
                return b;
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again. ex: 5.05");
                importDouble(a);

            }
        }
    }

    public Date importDate(String a) {
        while (true) {
            try {
                System.out.println("Enter " + a);
                Date b = new SimpleDateFormat("dd/MM/yyyy").parse(input.nextLine());
                return b;
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again. ex: 25/10/2022");
                importDate(a);
            }
        }
    }


    public String importString(String a) {
        while (true) {
            try {
                System.out.println("Enter " + a);
                String b = input.nextLine();
                return b;
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again.");
                importString(a);
            }
        }
    }

    public int choice(String a) {
        while (true) {
            try {
                System.out.println("Enter " + a);
                int b = Integer.parseInt(input.nextLine());
                if (b>0 || b<9) {
                    return b;
                } else {
                  return choice(a);
                }
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again.");
                importInt(a);
            }
        }
    }

}
