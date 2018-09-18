package me.vincent.rpncalculator;


import java.util.Scanner;

/**
 * RPN Calculator
 *
 * @author Vincent.Huang
 */

public class RPNCommandLineCalculator {

    public static void main(String[] args) {

        CalculationService calculationService = new RPNCalculationServiceImpl();

        System.out.println("RPN Command Line Calculator:");

        boolean EXIST_FLAG = false;

        do {
            Scanner sc = new Scanner(System.in);
            String commandString = sc.nextLine().trim();
            if (!commandString.equalsIgnoreCase("EXIT")) {
                calculationService.execute(commandString);
            }
        } while (!EXIST_FLAG);
    }
}
