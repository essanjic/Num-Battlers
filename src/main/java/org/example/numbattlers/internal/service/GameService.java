package org.example.numbattlers.internal.service;

import org.example.numbattlers.internal.entity.Player;

import java.util.Scanner;

public class GameService {
    public void startGame() {
        
        
        Scanner scanner = new Scanner(System.in);
        String namePlayer1 = String.valueOf(scanner.nextLine());
        Player player1 = new Player(namePlayer1, 0, 0);
        
        
    }
}
