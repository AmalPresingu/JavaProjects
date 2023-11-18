package edu.umsl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int heads;
        int tails;
        int attack;
        int counter = 0; //counting min moves
        int S; //If it is impossible to kill Hydra, S=−1,

        Scanner input = new Scanner(System.in);

        //prompting user for number of heads and tails for starter Hydra
        System.out.println("How many heads does the Hydra start off with: ");
        while (!input.hasNextInt()) { //validation
            System.out.println("Please re-enter the valid number of Hydra's heads: ");
            input.nextLine();
        }
        heads = input.nextInt();

        System.out.println("How many tails does the Hydra start off with: ");
        while (!input.hasNextInt()) {
            System.out.println("Please re-enter the valid number of Hydra's tails: ");
            input.nextLine();
        }
        tails = input.nextInt();

        //handles negative numbers
        while (heads < 0 || tails < 0) {
            System.out.println("Please re-enter positive integers: ");

            heads = input.nextInt();
            tails = input.nextInt();
        }

        //accessing methods from Moves to update Hydra
        Moves updateHydra = new Moves(heads, tails);

        do { //going through attack choices
            System.out.println("The Hydra has " + updateHydra.heads + " heads and " + updateHydra.tails + " tails.");
            System.out.println("Knight PyPy, enter an integer for your attack: ");
            System.out.println("Attack #1 - Slice 1 head (Hydra regenerates 1 new head)");
            System.out.println("Attack #2 - Slice 1 tail (Hydra regenerates 2 new tails)");
            System.out.println("Attack #3 - Slice 2 heads");
            System.out.println("Attack #4 - Slice 2 tails (Hydra regenerates 1 new head)");
            System.out.println("Enter 5 to retreat");

            while (!input.hasNextInt()) {
                System.out.println("Please re-enter a valid integer to attack the Hydra: ");
                input.nextLine();
            }
            attack = input.nextInt();

            switch (attack) { //using switch statement to go through each move and count minimum number of moves
                case 1:
                    updateHydra.move1(updateHydra);
                    counter++;
                    break;
                case 2:
                    updateHydra.move2(updateHydra);
                    counter++;
                    break;
                case 3:
                    if (updateHydra.heads >= 2) {
                        updateHydra.move3(updateHydra);
                        counter++;
                        break;
                    }
                    if (updateHydra.heads < 2) {
                        updateHydra.cancelHeads(updateHydra);
                        System.out.println("Your previous attack was blocked!");
                        break;
                    }
                case 4:
                    if (updateHydra.tails >= 2) {
                        updateHydra.move4(updateHydra);
                        counter++;
                        break;
                    }
                    if (updateHydra.tails < 2) {
                        updateHydra.cancelTails(updateHydra);
                        System.out.println("Your previous attack was blocked!");
                        break;
                    }
                case 5:
                    S = -1; //giving up condition
                    System.out.println("The Hydra is unbeatable. Game over.");
                    System.exit(0); //end program in successful manner
                default: //defaulting through input validation
                    while (attack > 5 || attack <= 0) {
                        System.out.println("Please enter a valid move 1-5: ");
                        attack = input.nextInt();
                    }
                    break;
            }
            if (updateHydra.heads == 1 && updateHydra.tails == 0) {
                System.out.println("The Hydra cannot be killed! Game over.");
                S = -1;
                System.exit(0);
            }
        } while (updateHydra.heads!=0 || updateHydra.tails !=0);

        //winning message
        System.out.println("The Hydra has been defeated!");
        S = counter;
        System.out.println("The minimum number of moves needed for Knight PyPy to slay the Hydra is " + S +" moves");
    }
}
