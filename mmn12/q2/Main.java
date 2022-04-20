import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Rational> rationals = new ArrayList<Rational>(); // Creating an arrayList to store the rational numbers from the user
        int numerator = 0, denominator = 0;

        for(int i = 0; i < 2; i++) {// Getting 2 rational number from user with validation that it's an int
            boolean valid = true;
            while(valid){
                try {
                    System.out.print("Please enter the numerator (int) for rational number " + (i + 1) + ": ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("That's not a valid input, please enter a valid number: ");
                        scanner.next();
                    }
                    numerator = scanner.nextInt();
                    System.out.print("Please enter the denominator (positive int) for rational number " + (i + 1) + ": ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("That's not a valid input, please enter a valid number: ");
                        scanner.next();
                    }
                    denominator = scanner.nextInt();
                    Rational rational = new Rational(numerator, denominator);
                    rationals.add(i, rational);
                } catch(IllegalArgumentException e){
                    System.out.println("The denominator should be a positive integer, please enter a valid number on the next try....");
                }
                if(denominator > 0){// I choose not to use finally
                    valid = false;
                }
            }
        }

        Rational r1 = rationals.get(0);
        Rational r2 = rationals.get(1);


        System.out.println("\nPrinting r1 & r2:");
        System.out.println(r1);// toString is called automatically
        System.out.println(r2);

        System.out.println("\nThe reduced rational numbers r1 & r2 are:");
        r1 = r1.reduce();
        r2 = r2.reduce();
        System.out.println(r1);// toString is called automatically
        System.out.println(r2);

        System.out.println("\nChecking the multiply function:");
        System.out.println(r1.printRational() + " * " + r2.printRational() + " = " + r1.multiply(r2).printRational());
        r1 = r1.reduce();
        r1.greaterThan(r2);
        System.out.println(r2); // toString is called automatically
        /*System.out.printf(r2.printRational() + " + " + r1.printRational() + " = " + r2.plus(r1));
        r2 = r2.reduce();*/

        System.out.println("\nChecking the minus function:");
        if(r1.equals(r2)){
            r1.minus(r2);
            r1 = r1.reduce();
        }else if(r1.greaterThan(r2)){
            r1.minus(r2);
            r1 = r1.reduce();
        } else {
            System.out.println(r2.printRational() + " - " + r1.printRational() + " = " + r2.minus(r1).printRational());
            r2 = r2.reduce();
        }
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("\nChecking the divide function with valid numbers:");
        try{
            System.out.println(r1.divide(r2));
            r1 = r1.reduce();
        } catch (ArithmeticException e){
            System.out.println("You are trying to divide by 0! set new denominator....");
        }

        System.out.println("\nChecking the plus function:");
        System.out.println(r1.printRational() + " + " + r2.printRational() + " = " + r1.plus(r2).printRational());
        r1 = r1.reduce();


        System.out.println("\nChecks the equal and greater than for equal numbers:");
        r1.setNumerator(8);
        r1.setDenominator(9);
        System.out.println("the new numerator for r1 is: " + r1.getNumerator());
        System.out.println("the new denominator for r1 is: " + r1.getDenominator());
        r2.setNumerator(8);
        r2.setDenominator(9);
        System.out.println("the new numerator for r2 is: " + r2.getNumerator());
        System.out.println("the new denominator for r2 is: " + r2.getDenominator());
        r1.equals(r2);
        r1.greaterThan(r2);
        r1.divide(r2);
        r1 = r1.reduce();

        System.out.println("\nChecking the divide function when dividing by 0:");
        r2.setNumerator(0);
        r2.setDenominator(1);
        System.out.println("the new numerator for r2 is: " + r2.getNumerator());
        System.out.println("the new denominator for r2 is: " + r2.getDenominator());
        try{
            System.out.println(r1.divide(r2));
            r1 = r1.reduce();
        } catch (ArithmeticException e){
            System.out.println("You are trying to divide by 0! set new numerator....");
        }
        r2.setNumerator(1);
        System.out.println("the new numerator for r2 is: " + r2.getNumerator());
        try{
            System.out.print("(" + r1.printRational() + ") / (" + r2.printRational() + ") = ");
            System.out.print(r1.divide(r2));
        } catch (ArithmeticException e){
            System.out.println("You are trying to divide by 0! set new numerator....");
        }
    }



}



