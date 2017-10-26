package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public abstract class Die {
    public enum ROLL {
        SHOT, RUN, BRAIN
    }

    public int roll()
    {
        return (int)(Math.random() * 6);
    }
}
