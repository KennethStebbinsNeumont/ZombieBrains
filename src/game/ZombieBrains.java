package game;

import game.dice.Die;

import java.util.Scanner;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class ZombieBrains {
    Player[] players;
//    int[] brains;
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
//        brains = new int[players.length];
        for(int i = 0; i < players.length; i++) {
            System.out.print("What's player " + (i + 1) + "'s name? ");
            players[i] = new Player(scanner.nextLine());
        }

        int currentBrains = 0;
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
                    rollLoop:
                    do {
                        Die[] dice = Cup.spawnDice();
                        for (Die die : dice) {
                            System.out.println(die + " rolled a " + die.roll());
                            if (die.roll() == Die.Roll.BRAIN) {
                                brains++;
                            } else if (die.roll() == Die.Roll.SHOT) {
                                shots++;
                            }
                        }

                        System.out.println("It's " + player + "'s turn!");
                        printDisplay(dice, player, brains, shots);

                        if (shots >= 3) {
                            System.out.println("You are dead!");
                            brains = 0;
                            break rollLoop;
                        } else if (brains >= 13) {
                            System.out.println("You have won!");
                        }
                        while(true) {
                            System.out.print("Do you want to roll again? [Y/N]: ");
                            String response = scanner.nextLine();
                            if (response.equalsIgnoreCase("n")) {
                                break rollLoop;
                            } else if (response.equalsIgnoreCase("y")) {
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
            System.out.println("Congratulations, " + winningPlayer + ", you've won!");
            while (true) {
                System.out.print("Do you want to play again? [Y/N]: ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("n")) {
                    break restartLoop;
                } else if (!response.equalsIgnoreCase("y")) {
                    System.out.println("Sorry! That response wasn't recognized!");
                }
            }
        }
    }

    public void printDisplay(Die[] dice, Player currentPlayer, int currentBrains, int currentShots)
    {
        /*
         * A roll is equal to one of these three:
         * Die.Roll.SHOT, Die.Roll.RUNNER, Die.Roll.BRAIN
         */
        System.out.println(currentPlayer + " has " + currentPlayer.brains() + " total brains.");
        for (Die die: dice) {
            System.out.print(die.name() + " rolled " + die.roll() + "    ");
        }
        System.out.println();
        System.out.println(currentPlayer + " has earned " + currentBrains + " brains and has been shot " + currentShots + " time(s) this round.");
        Player leadingPlayer = currentPlayer;
        Player runnerUp = currentPlayer;
        for(Player player : players) {
            if(player.brains() >= leadingPlayer.brains()) {
                runnerUp = leadingPlayer;
                leadingPlayer = player;
            }
        }
        if(leadingPlayer != currentPlayer) {
            System.out.println(leadingPlayer + " is in the lead with " + leadingPlayer.brains() + " brains.");
        } else {
            System.out.println(runnerUp + " is right behind you with " + runnerUp.brains() + " brains.");
        }
    }
}
