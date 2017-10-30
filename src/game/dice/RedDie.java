package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class RedDie extends Die
{
    private Roll roll;

    public Roll roll()
    {
        if(roll == null) {
            int r = getRoll();
            if (r <= 1) {
                return Roll.BRAIN;
            } else if (r <= 3) {
                return Roll.RUNNER;
            } else {
                return Roll.SHOT;
            }
        }
        return roll;
    }

    public String name() {return  "Red Die";}
}
