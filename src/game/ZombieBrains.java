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
        gameLoop:
        while(true) {
            roundLoop:
            while(true) {
                
            }
        }
    }
}
