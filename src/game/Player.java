package game;


import java.util.Scanner;

/**
 * @author Kenneth Stebbins - kstebbins@student.neumont.edu; manipulated/collaborated by Galen Schatzman - gschatzman@student.neumont.edu
 */
public class Player{

    private final String name;
    private int brains = 0;

    public Player(String _name){
      name = _name;
    }

    public String name(){
        return name;
    }

    public void setBrains(int _brains)
    {
        brains = _brains;
    }

    public int brains() { return brains; }

    @Override
    public String toString() { return name(); }
}
