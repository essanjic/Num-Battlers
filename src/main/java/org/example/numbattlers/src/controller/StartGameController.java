package org.example.numbattlers.src.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;

public class StartGameController {

    @FXML
    private Label messageLabel;

    @FXML
    public void startGame() {
        openGameSetupWindow();
    }

    @FXML
    public void exitGame() {
        messageLabel.setText("Gracias por jugar!");
    }

    private void openGameSetupWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/org/example/numbattlers/GameSetup-view.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del GameSetupController
            GameSetupController setupController = loader.getController();

            // Crear una nueva ventana de diálogo
            Stage setupStage = new Stage();
            setupStage.initModality(Modality.APPLICATION_MODAL);
            setupStage.setTitle("Configuración del Juego");
            setupStage.setScene(new Scene(root));

            // Mostrar la ventana de configuración del juego
            setupStage.showAndWait();

            // Una vez que se cierra la ventana de configuración, verificar las validaciones y comenzar el juego si todo está correcto
            if (setupController.isReadyToStart()) {
                // Aquí podrías obtener datos del GameSetupController si es necesario
                System.out.println("Iniciando juego...");
                playGame();
            } else {
                System.out.println("Configuración cancelada o inválida.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playGame() {
        //lógica del juego aquí
        displayScore();
        resetGame();
    }

    private void displayScore() {
        //lógica para mostrar el puntaje
        System.out.println("Mostrando puntaje...");
    }

    private void resetGame() {
        // Implementar la lógica para reiniciar el juego (si es necesario)
        System.out.println("Reiniciando juego...");
    }
}
