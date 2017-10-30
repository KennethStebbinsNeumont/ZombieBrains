package game;

import java.util.Scanner;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class ZombieBrains {
    public static void main(String[] args)
    {
        startGame();
    }

    public static void startGame()
    {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[2];
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
                 * Refresh UI (Show current player's name, brain count,
                 * dice rolled & their results, and second player's name &
                 * brain count).
                 * Spawn and roll the dice.
                 * Ask if they want to roll again or leave.
                 * Exit this loop automatically if they are "dead" or
                 * if they have greater than or equal to 13 brains.
                 * You can exit this loop by using:
                 * break roundLoop;
                 */
                }
                /*
                 * Check to see if someone has won yet (>= 13 brains)
                 * Break this loop with:
                 * break gameLoop:
                 */
            }
            /*
             * Ask if they want to play again
             */
        }
    }
}
