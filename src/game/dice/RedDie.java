package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public class RedDie extends Die {
   public Roll roll()
    {
        int roll = getRoll();
        if(roll <= 1) {
            return Roll.BRAIN;
        }else if(roll <= 3){
            return Roll.RUNNER;
        }else {
            return Roll.SHOT;
        }
    }

    public String name() {return  "Red Die";}
}
