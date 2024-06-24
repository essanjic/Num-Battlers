package org.example.numbattlers.src.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameSetupController {

    @FXML
    private TextField numPlayersField;

    @FXML
    private TextField player1NameField;

    @FXML
    private TextField player2NameField;

    @FXML
    private ChoiceBox<String> difficultyChoiceBox;

    @FXML
    private Label errorMessageLabel;

    private boolean readyToStart = false;

    @FXML
    public void startGame() {
        try {
            // Validar número de jugadores
            int numPlayers = Integer.parseInt(numPlayersField.getText());
            if (numPlayers != 1 && numPlayers != 2) {
                throw new IllegalArgumentException("Número inválido de jugadores, debe ser 1 o 2.");
            }

            // Validar nombres de jugadores y dificultad
            String player1Name = player1NameField.getText();
            String player2Name = player2NameField.getText();
            String selectedDifficulty = difficultyChoiceBox.getValue();

            if (numPlayers == 1) {
                if (player1Name.isEmpty()) {
                    throw new IllegalArgumentException("Ingrese el nombre del jugador 1.");
                }
            } else if (numPlayers == 2) {
                if (player1Name.isEmpty() || player2Name.isEmpty()) {
                    throw new IllegalArgumentException("Ingrese los nombres de ambos jugadores.");
                }
            }

            if (!selectedDifficulty.equals("Fácil") && !selectedDifficulty.equals("Difícil")) {
                throw new IllegalArgumentException("Número inválido de dificultad, debe ser 1 (Fácil) o 2 (Difícil).");
            }

            // Si todas las validaciones pasan, marcar como listo para iniciar el juego
            readyToStart = true;
            closeWindow();

        } catch (NumberFormatException e) {
            showError("El número de jugadores debe ser un valor numérico.");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String message) {
        errorMessageLabel.setText(message);
    }

    private void closeWindow() {
        // Cerrar la ventana de configuración del juego
        errorMessageLabel.getScene().getWindow().hide();
    }

    public boolean isReadyToStart() {
        return readyToStart;
    }
}
