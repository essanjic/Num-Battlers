package org.example.numbattlers.internal.entity;

/**
 * This class is used by a Game and extends the Player class.
 * Because extends the Player class, it has the same attributes and methods of the Player class.
 * Is possible create a new Methods in this class.
 */
public class Machine extends Player{
    private String difficulty;

    /**
     * Lines 14 - 18 are the constructor of the Player class.
     *
     * @param name
     * @param score
     * @param time
     */

    public Machine(String name, int score, int time) {
        super(name, score, time);
    }

    public String responseGenerate(){
        // TODO: Implement necessary GameService for generate a response
        return "implement me!";
    }

}
