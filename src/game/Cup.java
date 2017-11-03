package game;

import game.dice.Die;
import game.dice.GreenDie;
import game.dice.RedDie;
import game.dice.YellowDie;

import java.util.ArrayList;
import java.util.Arrays;

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

    private ArrayList<Die> dice = new ArrayList<>(0);
    private ArrayList<Die> toReRoll = new ArrayList<>(0);

    public Cup()
    {
        refillCup();
    }

    public void refillCup()
    {
        dice.clear();
        dice.addAll(Arrays.asList(new GreenDie(), new GreenDie(), new GreenDie(), new GreenDie(),
                new GreenDie(), new GreenDie(), new YellowDie(), new YellowDie(), new YellowDie(), new YellowDie(),
                new RedDie(), new RedDie(), new RedDie()));
    }

//    public static Die[] spawnDice() {
//        int randomNum = (int)(Math.random() * 13);
//        Die[] result = new Die[3];
//        for(int i = 0; i < result.length; i++) {
//            if (randomNum <= 46) {
//                result[i] = new GreenDie();
//            } else if (randomNum <= 77) {
//                result[i] = new YellowDie();
//            } else {
//                result[i] = new RedDie();
//            }
//        }
//        return result;
//    }

    public Die[] roll()
    {
        Die[] result = new Die[3];
        ArrayList<Die> toReRollQueue = new ArrayList<>();
        for(int i = 0; i < result.length; i++) {
            if(toReRoll.size() > 0) {
                result[i] = toReRoll.remove(0);
            } else {
                if (dice.size() < 3 - i) refillCup();
                int index = (int) (Math.random() * dice.size());
                result[i] = dice.remove(index);
            }
            result[i].reroll();
            if (result[i].roll().equals(Die.Roll.RUNNER)) {
                toReRollQueue.add(result[i]);
            }
        }
        toReRoll.addAll(toReRollQueue);
        return result;
    }

}
