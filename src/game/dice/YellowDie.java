package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class YellowDie extends Die
{
  public Roll roll()
    {
        int roll = getRoll();
        if(roll <= 2) {
            return Roll.BRAIN;
        }else if(roll <= 4){
            return Roll.RUNNER;
        }else {
            return Roll.SHOT;
        }
    }

    public String name() {return  "Yellow Die";}
}
