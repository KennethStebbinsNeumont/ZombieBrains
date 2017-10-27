package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class GreenDie extends Die {
    public Roll roll()
    {
        int roll = getRoll();
        if(roll <= 1) {
            return Roll.SHOT;
        } else if(roll <= 3) {
            return Roll.RUNNER;
        } else {
            return Roll.BRAIN;
        }
    }

    public String name()
    {
        return "Green Die";

    }
}
