package game;

import game.dice.Die;

import java.util.Scanner;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class ZombieBrains {
    Player[] players;
    int[] brains;
    Cup cup = new Cup();

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
        players = new Player[2];
        brains = new int[players.length];
        for(int i = 0; i < players.length; i++) {
            System.out.print("What's player " + i + "'s name? ");
            players[i] = new Player(scanner.nextLine());
        }

        int currentBrains = 0;
        restartLoop: // This loop allows for the whole game to be replayed
        while(true) {
            gameLoop: // This loop is for the current game
            while(true) {
                for(int i = 0; i < players.length; i++) {
                /*
                 * Store the number of brains temporarily.
                 * Ask if they want to roll again or leave.
                 * Exit this loop automatically if they are "dead" or
                 * if they have greater than or equal to 13 brains.
                 * If they die, reset the temporary brains amount
                 * to 0.
                 * You can exit this loop by using:
                 * break roundLoop;
                 */

                    Die[] dice = new Die[3];
                    for (int j = 0; j < dice.length; j++) {
                        dice[i] = Cup.decideColor(Cup.getRandomNum());
                        Cup.newRandomNum();
                    }
                    printDisplay(dice, i, brains[i], currentBrains);
                }

                /*
                 * Store the new number of brains in the brains array
                 * in the right place (i.e. player 0 gets brains index 0).
                 * Check to see if the opponent has >= 13 brains). If they do,
                 * check to see if the current player has more brains. If the
                 * current player has more brains, they win. Otherwise, the opponent
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

    public void printDisplay(Die[] dice, int playerIndex, int brainsObtained, int currentBrains)
    {
        /*
         * A roll is equal to one of these three:
         * Die.Roll.SHOT, Die.Roll.RUNNER, Die.Roll.BRAIN
         */
        System.out.println(players[playerIndex] + " has " + brainsObtained + " brains.");
        System.out.println("You have earned " + currentBrains + " brains this round.");
        System.out.println(dice[0].name() + " rolled " + dice[0].roll());
        System.out.println(dice[1].name() + " rolled " + dice[1].roll());
        System.out.println(dice[2].name() + " rolled " + dice[2].roll());
        if (playerIndex == 0) {
            System.out.println((players[playerIndex + 1]) + " has " + brains[playerIndex + 1] + " brains.");
        } if (playerIndex == 1) {
            System.out.println((players[playerIndex - 1]) + " has " + brains[playerIndex - 1] + " brains.");
        }
    }
}
