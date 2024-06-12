package org.example.numbattlers.internal.service;

import javafx.fxml.FXML;
import org.example.numbattlers.internal.entity.Machine;
import org.example.numbattlers.internal.entity.Player;

import java.util.Scanner;

public class GameService {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de jugadores (1 o 2):");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        if (numPlayers != 1 && numPlayers != 2) {
            throw new IllegalArgumentException("Número inválido de jugadores, debe ser 1 o 2.");
        } else if (numPlayers == 1) {
            System.out.println("Ingrese el nombre del jugador 1:");
            String namePlayer1 = String.valueOf(scanner.nextLine());
            Player player1 = new Player(namePlayer1, 0, 0);;
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Ingrese la dificultad (1. Fácil o 2 Difícil):");
            int difficulty = scanner2.nextInt();
            if (difficulty != 1 && difficulty != 2) {
                throw new IllegalArgumentException("Número inválido de dificultad, debe ser 1 o 2.");
            }
            MachineService.GetMachine(difficulty);

        } else {
            System.out.println("Ingrese el nombre del jugador 1:");
            String namePlayer1 = String.valueOf(scanner.nextLine());
            Player player1 = new Player(namePlayer1, 0, 0);
            System.out.println("Ingrese el nombre del jugador 2:");
            String namePlayer2 = String.valueOf(scanner.nextLine());
            Player player2 = new Player(namePlayer2, 0, 0);
        }



        String namePlayer1 = String.valueOf(scanner.nextLine());
        Player player1 = new Player(namePlayer1, 0, 0);
        
        
    }
}
