package game.dice;

/**
 * @author Byron Slavey and Kenneth Stebbins
 */
public class RedDie extends Die
{
    private Roll roll;

    public Roll reroll()
    {
        int r = getRoll();
        if (r <= 1) {
            roll = Roll.BRAIN;
        } else if (r <= 3) {
            roll = Roll.RUNNER;
        } else {
            roll = Roll.SHOT;
        }
        return roll;
    }

    public Roll roll()
    {
        if(roll == null) {
            return reroll();
        }
        return roll;
    }

    public String name() {return  "Red Die";}
}
