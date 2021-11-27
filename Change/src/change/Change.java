/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package change;
import java.util.*;


/**
 *
 * @author Donna Seidel
 */
public class Change {
        static Scanner sc=new Scanner(System.in);
        static int change;
        static int prompt;

    public static void main(String[] args) {
        int chg;
        System.out.println("Welcome to the Perfect Change calculator!");
        chg = getChangeAmount();
        while (chg != 0 ) { //test before and execute as long as true
            {   
            makeChange(chg);
//            System.out.println("main loop - change amout = " + chg);  
            }  
            chg = getChangeAmount();
        } //end while
        System.out.println("\nThanks for using the Perfect Change calculator! ");
    }//end of main

        
    public static int getChangeAmount() {    
    // could pass coin type and value as variables and reiterate code 
        int c = 0;
        System.out.println("\nWhat value would you like change for? (1-99 cents, or 0=quit): ");
        change = getIntPositive (sc, prompt);
        return change;
    
        } //end getChangeAmount
    
    public static int getIntPositive(Scanner sc, int prompt)
    {    
        int c = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            c = getInt(sc, prompt);
            if (c < 0 || c > 99){ //amount must be positive, AND between 1-99
                System.out.println(
                    "Error! Illegal amount; please enter value(1-99 cents, or 0=quit):"); }
            else
                isValid = true;
        }//end of while
        return c;
    }//end of getIntPositive
    
        public static int getInt(Scanner sc, int prompt)
    {
        int c = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            //System.out.print(prompt);
            if (sc.hasNextInt())
            {
                c = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value (1-99 cents, or 0=quit): ");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return c;
    }//end of getInt
    
  
    public static void makeChange(int chg) {
        
    //System.out.println("Made it to makeChange");
        int amt=chg; //save off ChangeAmount
        
        //coins on hand - method scope
        int ohQuarters=3; //initial amt of quarters
        int ohDimes=1;    //initial amt of dimes
        int ohNickels=2;  //initial amt of nickels
        int ohPennies=4;  //initial amt of pennies
        
        int uQuarters=0; //used amt of quarters
        int uDimes=0;    //used amt of dimes
        int uNickels=0;  //used amt of nickels
        int uPennies=0;  //used amt of pennies
        
        //value of each coin type - method scope
        int q=25;   
        int d=10;
        int n=5;
        int p=1;
       
        int qtyneeded = 0; //number of coins needed

       
        //how many quarters
        qtyneeded = amt / q;
            if (ohQuarters >= qtyneeded) {
                uQuarters = qtyneeded;
            } else {
                if (ohQuarters < qtyneeded) {
                  uQuarters = ohQuarters;  
                } //endif
        }//endif
        ohQuarters = ohQuarters - uQuarters;
        amt = (amt - (uQuarters * q)); //determine change remaining
        //System.out.println("uQuarters " + uQuarters + " ohQuarters " + ohQuarters + " amt " + amt); 
       
        
        //how many dimes       
        qtyneeded = amt / d;
            if (ohDimes >= qtyneeded) {
                uDimes = qtyneeded;
            } else {
                if (ohDimes < qtyneeded) {
                  uDimes = ohDimes;  
                } //endif
        }//endif
        ohDimes = ohDimes - uDimes;
        amt = (amt - (uDimes * d)); //determine change remaining
        //System.out.println("uDimes " + uDimes + " ohDimes " + ohDimes + " amt " + amt); 

        
        //how many nickels       
       qtyneeded = amt / n;
           if (ohNickels >= qtyneeded) {
                uNickels = qtyneeded;
            } else {
                if (ohNickels < qtyneeded) {
                  uNickels = ohNickels;  
                } //endif
        }//endif
        ohNickels = ohNickels - uNickels;
        amt = (amt - (uNickels * n)); //determine change remaining
        //System.out.println("uNickels " + uNickels + " ohNickels " + ohNickels + " amt " + amt); 

        
        //how many pennies       
        qtyneeded = amt / p;
            if (ohPennies >= qtyneeded) {
                uPennies = qtyneeded;
            } else {
                if (ohPennies < qtyneeded) {
                  uPennies = ohPennies;  
                } //endif
        } //endif
        ohPennies = ohPennies - uPennies;
        amt = (amt - (uPennies * p)); //determine change remaining
        //System.out.println("uPenniess " + uPennies + " ohPennies " + ohPennies + " amt " + amt); 

        
        if (amt == 0) {
            System.out.println("\nFor " + chg + " cent(s) I give: ");
            System.out.println("        " + uQuarters + " quarters, " + uDimes + " dime " + uNickels + " nickels, " + uPennies + " pennies leaving:");
            System.out.println("        " + ohQuarters + " quarters, " + ohDimes + " dime " + ohNickels + " nickels, " + ohPennies + " pennies ");
        } else {
           System.out.println("Change cannot be made for " + chg);

        }

        return; //to main

    }//end of getChange

}//end of class
