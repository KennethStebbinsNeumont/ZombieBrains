package game.dice;
//yeet
/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu
 */
public abstract class Die {
    public enum Roll {
        SHOT ("Shot"), RUNNER ("Runner"), BRAIN ("Brain!");

        private final String name;

        Roll(String n)
        {
            name = n;
        }

        @Override
        public String toString()
        {
            return name;
        }
    }

    protected int getRoll()
    {
        return (int)(Math.random() * 6);
    }

    public abstract Roll roll();
    public abstract Roll reroll();
    public abstract String name();
    @Override
    public String toString()
    {
        return name();
    }
}
