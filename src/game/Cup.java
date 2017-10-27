package game;

import game.dice.Die;
import game.dice.GreenDie;
import game.dice.RedDie;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class Cup {
//    private Die[] dice = new Die[]{new RedDie(), new RedDie(), new RedDie(), new GreenDie(), new GreenDie(), new GreenDie()}
//    Cup – This class is responsible for producing dice (meaning instances of Die) as needed.
//    It will do so via a method that will produce a die randomly based on the previously mentioned chances of getting Green vs. Yellow vs. Red.
//    See the Game Rules section for the percentage of each color.
//    Model this Cup class as though it is magical, capable of producing infinite dice.
//    The method should return one Die instance each time it is called. Also, the method should be static (why?).
private static double randomNum = Math.random() * 100;

    public static double getRandomNum() {
        return randomNum;
    }

    public static void newRandomNum() {
        randomNum = Math.random() * 100;
    }

    public static String decideColor (int randomNum) {
        if (randomNum <= 46) {
            return "green";
        } else if (randomNum <= 77) {
            return "yellow";
        } else {
            return "red";
        }
    }
}
