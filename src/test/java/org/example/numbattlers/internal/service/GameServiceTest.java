package org.example.numbattlers.internal.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {
    @Test
    void testDisplayMenu() {
        // Arrange
        String expectedSout = "1. Iniciar juego\n2. Salir\n";

        // Act
        GameService gameService = new GameService();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        gameService.displayMenu();
        String actualOutput = outContent.toString().replace("\r\n", "\n");

        // Assert
        assertEquals(expectedSout, actualOutput);
    }

}
