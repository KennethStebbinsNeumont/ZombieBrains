package game;

import game.dice.Die;
import game.dice.GreenDie;
import game.dice.RedDie;
import game.dice.YellowDie;

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

    public static Die[] spawnDice() {
        int randomNum = (int)(Math.random() * 100);
        Die[] result = new Die[3];
        for(int i = 0; i < result.length; i++) {
            if (randomNum <= 46) {
                result[i] = new GreenDie();
            } else if (randomNum <= 77) {
                result[i] = new YellowDie();
            } else {
                result[i] = new RedDie();
            }
        }
        return result;
    }
}
