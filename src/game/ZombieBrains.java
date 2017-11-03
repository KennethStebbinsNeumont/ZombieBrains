package game;

import game.dice.Die;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class ZombieBrains {
    ArrayList<Player> players = new ArrayList<Player>(0);
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
//        brains = new int[players.length];
        System.out.println("Please enter the names of every player. When you're done, just press ENTER to play the game.");
        while(true) {
            System.out.print("What's player " + (players.size() + 1) + "'s name? ");
            String response = scanner.nextLine();
            if(response.equalsIgnoreCase("")) break;
            players.add(new Player(response));
        }

        int currentBrains = 0;
        Cup cup = new Cup();
        restartLoop: // This loop allows for the whole game to be replayed
        while(true) {
            Player winningPlayer = null;
            gameLoop:
            // This loop is for the current game
            while (true) {
                for (Player player : players) {
                    if (player.brains() >= 13) {
                        Player winner = player;
                        for (Player p : players) {
                            if (p.brains() > winner.brains()) winner = p;
                        }
                        winningPlayer = winner;
                        break gameLoop;
                    }
                    int brains = 0;
                    int shots = 0;
                    cup.refillCup();
                    rollLoop:
                    do {
                        System.out.println("It's " + player + "'s turn!");
                        Die[] dice = cup.roll();
                        for (Die die : dice) {
                            System.out.println("You got a " + die.roll() + " from a " + die);
                            if (die.roll() == Die.Roll.BRAIN) {
                                brains++;
                            } else if (die.roll() == Die.Roll.SHOT) {
                                shots++;
                            }
                        }
                        printDisplay(player, brains, shots);

                        if (shots >= 3) {
                            System.out.println("You are dead!\n");
                            brains = 0;
                            break rollLoop;
                        } else if (brains >= 13) {
                            System.out.println("You have won!");
                        }
                        while(true) {
                            System.out.print("Do you want to roll again? [Y/N]: ");
                            String response = scanner.nextLine();
                            if (response.equalsIgnoreCase("n")) {
                                System.out.println("\n"); // Add an extra empty line
                                break rollLoop;
                            } else if (response.equalsIgnoreCase("y")) {
                                System.out.println();
                                break;
                            } else {
                                System.out.println("Sorry! That response wasn't recognized!");
                            }
                        }
                    } while(true);
                    player.setBrains(player.brains() + brains);
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
            System.out.println("\nCongratulations, " + winningPlayer + ", you've won with " + winningPlayer.brains() +
                    " brains!");
            players.sort(Comparator.comparingInt(Player::brains));
            System.out.println("Here's who you beat:");
            for(Player player : (Player[])players.toArray()) {
                if(players.indexOf(player) > 0) System.out.print(", ");
                System.out.print(player + " [" + player.brains() + "]");
            }
            while (true) {
                System.out.print("Do you want to play again? [Y/N]: ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("n")) {
                    break restartLoop;
                } else if (!response.equalsIgnoreCase("y")) {
                    System.out.println("Sorry! That response wasn't recognized!");
                }
                System.out.println("\n\n\n");
            }
        }
    }

    private void printDisplay(Player currentPlayer, int currentBrains, int currentShots)
    {
        /*
         * A roll is equal to one of these three:
         * Die.Roll.SHOT, Die.Roll.RUNNER, Die.Roll.BRAIN
         */
        System.out.println("\n" + currentPlayer + " has " + currentPlayer.brains() + " total brains.");
        System.out.println(currentPlayer + " has earned " + currentBrains + " brains and has been shot " +
                currentShots + " time(s) this round.");
    }

    private void printDisplay(Player currentPlayer)
    {
        Player leadingPlayer = currentPlayer;
        Player runnerUp = currentPlayer;
        for(Player player : players) {
            if(player.brains() >= leadingPlayer.brains()) {
                leadingPlayer = player;
            } else {
                runnerUp = player;
            }
        }
        if(leadingPlayer.brains() > currentPlayer.brains()) {
            System.out.println(leadingPlayer + " is in the lead with " + leadingPlayer.brains() + " brains.");
        } else if(leadingPlayer.brains() == currentPlayer.brains()) {
            System.out.println("You're currently neck and neck with " + leadingPlayer + " with " +
                    leadingPlayer.brains() + " brains.");
        } else {
            System.out.println(runnerUp + " is right behind you with " + runnerUp.brains() + " brains.");
        }
    }
}
