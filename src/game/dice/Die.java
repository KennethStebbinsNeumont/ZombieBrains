package game.dice;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public abstract class Die {
    public enum Roll {
        SHOT, RUNNER, BRAIN
    }

    protected int getRoll()
    {
        return (int)(Math.random() * 6);
    }

    public abstract Roll roll();
    public abstract String name();
}
