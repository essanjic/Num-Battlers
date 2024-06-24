package org.example.numbattlers.internal.entity;

/** This class is used by Game to ask the player for a response to a question.
 * Implements some attributes of the question.
 */
public class Question {
    /** Lines 8 - 13 are the attributes of the Question class. */

    private int key;
    private String declare;

    private String response;

    private String level;

    private int maxTime;

    /** Lines 15 - 20 are the constructor of the Question class. */
    public Question(int key, String declare, String response, String level, int maxTime) {
        this.key = key;
        this.declare = declare;
        this.response = response;
        this.level = level;
        this.maxTime = maxTime;
    }

/** Lines 27 - 57 are the getter and setter methods of the Question class.
 * They are used to access and modify the attributes of the Question class.
 * The Gets methods are used by call and return specific attributes @return declare, response, level, maxTime
 * The Sets methods are used by modify the specific attributes of the class @param declare, response, level, maxTime and returns void
  */
    public String getDeclare() {
        return declare;
    }

    public int getKey() {
        return key;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

}
