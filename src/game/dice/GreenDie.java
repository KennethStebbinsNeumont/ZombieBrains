package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class GreenDie extends Die {
    private Roll roll;

    public Roll previousRoll()
    {
        if(roll == null) {
            reroll();
        }
        return roll;
    }

    public Roll reroll()
    {
        int r = getRoll();
        if (r <= 1) {
            roll = Roll.SHOT;
        } else if (r <= 3) {
            roll = Roll.RUNNER;
        } else {
            roll = Roll.BRAIN;
        }
        return roll;
    }

    public String name()
    {
        return "Green Die";

    }
}
