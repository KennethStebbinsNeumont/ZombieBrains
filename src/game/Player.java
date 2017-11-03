package game;


import java.util.Scanner;

/**
 * @author Galen Schatzman and Kenneth Stebbins
 */
public class Player{

    String name;

    public Player(String _name){
      name = _name;
    }

    public String name(){
        return name;
    }

    @Override
    public String toString() { return name(); }
}
