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
                    int BrainHolder = 0;
                    int ShotCounter = 0;
                    rollLoop:
                    do {
                        Die[] dice = new Die[3];
                        for (int j = 0; j < dice.length; j++) {
                            dice[i] = Cup.decideColor(Cup.getRandomNum());
                            Cup.newRandomNum();
                        }

                        for (int j = 0; j < dice.length; j++) {
                            dice[i].roll();
                            if (dice[i].roll().equals(Die.Roll.BRAIN)) {
                                BrainHolder++;
                            }
                            if (dice[i].roll().equals(Die.Roll.SHOT)) {
                                ShotCounter++;
                            }
                        }

                        printDisplay(dice, i, brains[i], currentBrains);

                        if (ShotCounter >= 3) {
                            System.out.println("You are dead!");
                            BrainHolder = 0;
                            break rollLoop;
                        } else if (BrainHolder >= 13) {
                            System.out.println("You have won!");
                        }
                        while(true) {
                            System.out.print("Do you want to roll again? [Y/N]");
                            String response = scanner.nextLine();
                            if(response.equalsIgnoreCase("n")) {
                                break rollLoop;
                            } else if(!response.equalsIgnoreCase("y")) {
                                System.out.println("Sorry! That response wasn't recognized!");
                            }
                        }
                    } while(true);
                    brains[i] += BrainHolder;
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
        Player leadingPlayer = players[playerIndex];
        int greatestBrains = brains[playerIndex];
        for(int i = 0; i < brains.length; i++) {
            if(brains[i] >= greatestBrains) leadingPlayer = players[i];
        }
        System.out.println(leadingPlayer + " is in the lead with " + greatestBrains + " brains.");
    }
}
