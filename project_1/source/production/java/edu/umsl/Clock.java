/*
Amal Presingu
2/14/2021
Display converted time (subtract 45 mins)
 */
package edu.umsl;

import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {

        String input;
        int hour = 0;
        int min = 0;
        boolean check = false;

        System.out.println("Please enter two integers in 24-hour notation: ");

        while (check == false) { //while loop wrapping try/catch block

            //user input
            Scanner givenTime = new Scanner(System.in);
            input = givenTime.nextLine();

            try { //parse for formatting
                hour = Integer.parseInt(input.split(" ")[0]);
                min = Integer.parseInt(input.split(" ")[1]);

                //The first and only line of input will contain exactly two integers H and M (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
                if (hour >= 0 && hour <= 23) {
                    if (min >= 0 && min <= 59) {
                        check = true; //establishing bounds and ensuring valid input
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                check = false;
            }
              catch (NumberFormatException e) {
                check = false;
            }
            if (check == false) //will jump back up to re-prompt user for a valid time
                System.out.println("Please enter a valid input: ");
        }
        //logic for subtracting 45 minutes
        if (min >= 45) {
            min = min - 45;
        }
        else {
            min = min + 15;

            if (hour == 0) {
                hour = 23;
            } else
                hour = hour - 1;
        }

        //display new timestamp
        if (min < 10) {
            System.out.println("Timestamp: " + hour + ":" + "0" + min);
        }
        else {
            System.out.println("Timestamp: " + hour + ":" + min);
        }
    }
}