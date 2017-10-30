package game;

import game.dice.Die;

import java.util.Scanner;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class ZombieBrains {
    Player[] players = new Player[2];
    int[] brains = new int[2];

    public static void main(String[] args)
    {
        new ZombieBrains();
    }

    public ZombieBrains()
    {
        startGame();
    }

    public void startGame()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's player 1's name? ");
        players[1] = new Player(scanner.nextLine());
        System.out.print("What's player 2's name? ");
        players[2] = new Player(scanner.nextLine());

        int currentPlayer = 0;
        restartLoop: // This loop allows for the whole game to be replayed
        while(true) {
            gameLoop: // This loop is for the current game
            // Change which player has their "turn"
            while(true) {
                roundLoop:
                while(true) {

                /*
                 * Spawn and store the roll of the dice.
                 * Refresh UI (Show current player's name, brain count,
                 * dice rolled & their results, and second player's name &
                 * brain count). Pass the rolls of the dice.
                 * Store the number of brains temporarily.
                 * Ask if they want to roll again or leave.
                 * Exit this loop automatically if they are "dead" or
                 * if they have greater than or equal to 13 brains.
                 * If they die, reset the temporary brains amount
                 * to 0.
                 * You can exit this loop by using:
                 * break roundLoop;
                 */
                }
                /*
                 * Store the new number of brains in the brains array
                 * in the right place (i.e. player 0 gets brains index 0).
                 * Check to see if the opponent has >= 13 brains). If they do,
                 * check to see if the current player has more brains. If the
                 * current player has more brains, they win. Otherise, the opponent
                 * wins.
                 * Break this loop with:
                 * break gameLoop:
                 */
            }
            /*
             * Ask if they want to play again
             */
        }
    }

    public void printDisplay(Die.Roll[] rolls)
    {
        /*
         * A roll is equal to one of these three:
         * Die.Roll.SHOT, Die.Roll.RUNNER, Die.Roll.BRAIN
         */
    }
}
