package org.example.numbattlers;

/** This class is used by Game to store the player's name, score, and time.
 * Implements some attributes of the player.
 * The player have a possibility to play the game and get a score and time.
 */
public class Player {
    /** Lines 9 - 11 are the attributes of the Player class. */
    private String name;
    private int score;
    private int time;

    /** Lines 14 - 18 are the constructor of the Player class. */
    public Player(String name, int score, int time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }

    /** Lines 25 - 47 are the getter and setter methods of the Player class.
     * They are used to access and modify the attributes of the Player class.
     * The Gets methods are used by call and return specific attributes @return name, score, time
     * The Sets methods are used by modify the specific attributes of the class @param name, score, time and returns void
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
