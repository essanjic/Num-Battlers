package org.example.numbattlers.internal.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void testResponseGenerate() {
        // Arrange
        Player playerTest = new Player("TestPlayer", 0, 0);

        // Act
        playerTest.setScore(200);
        playerTest.getName();
        playerTest.setName("OtherPlayer");
        playerTest.getTime();

        // Assert
        assertEquals(200, playerTest.getScore());
        assertEquals("OtherPlayer", playerTest.getName());
        assertEquals(0, playerTest.getTime());

    }
}
