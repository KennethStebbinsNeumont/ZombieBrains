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

        int currentBrains = 0;
        restartLoop: // This loop allows for the whole game to be replayed
        while(true) {
            players = new Player[2];
            brains = new int[players.length];
            for(int i = 0; i < players.length; i++) {
                System.out.print("What's player " + (i+1) + "'s name? ");
                players[i] = new Player(scanner.nextLine());
            }
            gameLoop: // This loop is for the current game
            while(true) {
                for(int i = 0; i < players.length; i++) {
                    System.out.println("\nIt's " + players[i] + "'s turn!");
                    int BrainHolder = 0;
                    int ShotCounter = 0;
                    Die[] reroll = new Die[3];
                    rollLoop:
                    do {
                        Die[] dice = new Die[3];
                        for (int j = 0; j < dice.length; j++) {
                            if(reroll[j] != null) {
                                dice[j] = reroll[j];
                                reroll[j] = null;
                            } else {
                                dice[j] = Cup.decideColor(Cup.getRandomNum());
                                Cup.newRandomNum();
                            }
                        }

                        for (int j = 0; j < dice.length; j++) {
                            dice[j].reroll();
                            if (dice[j].roll().equals(Die.Roll.BRAIN)) {
                                BrainHolder++;
                            } else if (dice[j].roll().equals(Die.Roll.SHOT)) {
                                ShotCounter++;
                            } else {
                                reroll[j] = dice[j];
                            }
                        }

                        printDisplay(dice, i, brains[i], BrainHolder, ShotCounter);

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
                            } else if(response.equalsIgnoreCase("y")) {
                                break;
                            } else {
                                System.out.println("Sorry! That response wasn't recognized!");
                            }
                        }
                    } while(true);
                    brains[i] += BrainHolder;
                    if(brains[i] >= 13) {
                        System.out.println("Player " + players[0] + " has won!!!!?!!?!!!!?!");
                        break gameLoop;
                    }
//                    if (i == 0 && brains[1] >= 13){
//                        if (brains[0] > brains[1]){
//                            System.out.println("Player " + players[0] + " has won!!!!?!!?!!!!?!");
//                        }
//                        else{
//                            System.out.println("Player " + players[1] + " has won!!!!?!!?!!!!?!");
//                        }
//                        break gameLoop;
//                    } else if (i == 1 && brains[0] >= 13){
//                        if (brains[0] > brains[1]){
//                            System.out.println("Player " + players[0] + " has won!!!!?!!?!!!!?!");
//                        }
//                        else{
//                            System.out.println("Player " + players[1] + " has won!!!!?!!?!!!!?!");
//                        }
//                        break gameLoop;
//                    }
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
            String playAgain = "";
            while (true) {
                System.out.print("Would you like to play again? Yes or No: ");
                playAgain = scanner.nextLine();
                if(playAgain.equalsIgnoreCase("yes")) {
                    System.out.println("Alright! Firing back up...");
                    break;
                } else if(playAgain.equalsIgnoreCase("no")) {
                    System.out.println("Thank for playing!");
                    break restartLoop;
                } else {
                    System.out.println("Sorry! That input wasn't recognized. Please try again.");
                }

            }

        }
    }

    public void printDisplay(Die[] dice, int playerIndex, int brainsObtained, int currentBrains, int shots)
    {
        /*
         * A roll is equal to one of these three:
         * Die.Roll.SHOT, Die.Roll.RUNNER, Die.Roll.BRAIN
         */
        System.out.println(dice[0].name() + " rolled " + dice[0].roll());
        System.out.println(dice[1].name() + " rolled " + dice[1].roll());
        System.out.println(dice[2].name() + " rolled " + dice[2].roll());
        System.out.println(players[playerIndex] + " has " + brainsObtained + " brains.");
        System.out.println("You have earned " + currentBrains + " brains and have been shot " + shots + " this round.");
        Player leadingPlayer = players[playerIndex];
        int greatestBrains = brains[playerIndex];
        for(int i = 0; i < brains.length; i++) {
            if(brains[i] >= greatestBrains) {
                leadingPlayer = players[i];
                greatestBrains = brains[i];
            }
        }
        System.out.println(leadingPlayer + " is in the lead with " + greatestBrains + " brains.");
    }
}
