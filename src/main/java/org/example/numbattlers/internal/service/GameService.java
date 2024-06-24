package org.example.numbattlers.internal.service;

import java.util.Scanner;

import com.almasb.fxgl.quest.Quest;
import org.example.numbattlers.internal.entity.Machine;
import org.example.numbattlers.internal.entity.Player;
import java.util.InputMismatchException;

public class GameService {
    private QuestionService questionService;
    private MachineService machineService;
    private Machine machine;
    private Player singlePlayer;
    private Player playerOne;
    private Player playerTwo;
    private static final String QUESTION_SERVICE_REPO = "src/main/java/org/example/numbattlers/internal/repository/seeders.json";

    public void displayMenu() {
        System.out.println("1. Iniciar juego");
        System.out.println("2. Salir");
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            displayMenu();
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        playGame(scanner);
                        displayScore();
                        resetGame();
                        break;
                    case 2:
                        System.out.println("Gracias por jugar!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija 1 o 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        } while (choice != 2);
    }
    public void playGame(Scanner scanner) {
        QuestionService questionService = new QuestionService(QUESTION_SERVICE_REPO);
        System.out.println("¡Bienvenido a NumBattlers!");
        System.out.println("Ingrese el número de jugadores (1 o 2):");
        Scanner numberPlayers = new Scanner(System.in);
        int numPlayers = numberPlayers.nextInt();
        numberPlayers.nextLine();
        if (numPlayers != 1 && numPlayers != 2) {
            throw new IllegalArgumentException("Número inválido de jugadores, debe ser 1 o 2.");
        } else if (numPlayers == 1) {
            System.out.println("Ingrese el nombre del jugador 1:");
            Scanner nameSinglePlayerIn = new Scanner(System.in);
            String nameSinglePlayer = String.valueOf(nameSinglePlayerIn.nextLine());
            Player singlePlayer = new Player(nameSinglePlayer, 0, 0);;
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Ingrese la dificultad (1. Fácil o 2 Difícil):");
            int difficulty = scanner2.nextInt();
            if (difficulty != 1 && difficulty != 2) {
                throw new IllegalArgumentException("Número inválido de dificultad, debe ser 1 o 2.");
            }else if (difficulty == 1) {
                Scanner scanner3 = new Scanner(System.in);
                questionService.askQuestions(singlePlayer, scanner3, "fácil");
                machineService.machinePlay(machine, "fácil");
            }else {
                Scanner scanner3 = new Scanner(System.in);
                questionService.askQuestions(singlePlayer, scanner3, "difícil");
                machineService.machinePlay(machine, "difícil");
            }
        } else {
            System.out.println("Ingrese el nombre del jugador 1:");
            Scanner namePlayerOneIn = new Scanner(System.in);
            String namePlayerOne = String.valueOf(namePlayerOneIn.nextLine());
            Player playerOne = new Player(namePlayerOne, 0, 0);
            System.out.println("Ingrese el nombre del jugador 2:");
            Scanner namePlayerTwoIn = new Scanner(System.in);
            String namePlayerTwo = String.valueOf(namePlayerTwoIn.nextLine());
            Player playerTwo = new Player(namePlayerTwo, 0, 0);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Ingrese la dificultad (1. Fácil o 2 Difícil):");
            int difficulty = scanner2.nextInt();
            if (difficulty != 1 && difficulty != 2) {
                throw new IllegalArgumentException("Número inválido de dificultad, debe ser 1 o 2.");
            }else if (difficulty == 1) {
                Scanner scanner3 = new Scanner(System.in);
                questionService.askQuestions(playerOne, scanner3, "fácil");
                questionService.askQuestions(playerTwo, scanner3, "fácil");
            }else {
                Scanner scanner3 = new Scanner(System.in);
                questionService.askQuestions(playerOne, scanner3, "difícil");
                questionService.askQuestions(playerTwo, scanner3, "difícil");
            }
        }
    }
    private void displayScore() {
        if (singlePlayer != null) {
            if (singlePlayer.getScore() > machine.getScore()) {
                System.out.println("¡Felicidades " + singlePlayer.getName() + ", has ganado el juego!\n Tu puntaje es de: " + singlePlayer.getScore() + " puntos."
                + "\n El puntaje de la máquina fue de: " + machine.getScore() + " puntos.");
            } else if (singlePlayer.getScore() < machine.getScore()) {
                System.out.println("Lo siento " + singlePlayer.getName() + ", la máquina ha ganado el juego. \n Su puntaje fue de: " + machine.getScore() + " puntos."
                + "\n Tu puntaje fue de: " + singlePlayer.getScore() + " puntos. Mucha suerte en tu próximo intento." );
            } else {
                System.out.println("Es un empate! \n Tu puntaje fue de: " + singlePlayer.getScore() + " puntos. \n Mientras que el de la máquina fue de: " + machine.getScore() + " puntos.");
            }
        } else {
            if (playerOne.getScore() > playerTwo.getScore()) {
                System.out.println("¡Felicidades " + playerOne.getName() + ", has ganado el juego! \n Tu puntaje fue de: " + playerOne.getScore() + " puntos."
                + "\n El puntaje de " + playerTwo.getName() + " fue de: " + playerTwo.getScore() + " puntos.");
            } else if (playerOne.getScore() < playerTwo.getScore()) {
                System.out.println("¡Felicidades " + playerTwo.getName() + ", has ganado el juego! \n Tu puntaje fue de: " + playerTwo.getScore() + " puntos." +
                    "\n El puntaje de " + playerOne.getName() + " fue de: " + playerOne.getScore() + " puntos.");
            } else {
                System.out.println("Es un empate! \n El puntaje de " + playerOne.getName() + " fue de: " + playerOne.getScore() + " puntos. " +
                        "\n Mientras que el de " + playerTwo.getName() + " fue de: " + playerTwo.getScore() + " puntos.");
            }
        }
    }

    private void resetGame() {

        if (singlePlayer != null) {
            singlePlayer.setScore(0);
            machine.setScore(0);
        } else {
            playerOne.setScore(0);
            playerTwo.setScore(0);
        }
    }
}

