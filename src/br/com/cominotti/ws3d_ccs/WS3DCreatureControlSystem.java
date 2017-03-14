/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cominotti.ws3d_ccs;

import br.com.cominotti.ws3d_ccs.application.ApplicationState;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseInput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class WS3DCreatureControlSystem extends Application {

    private final static Logger LOGGER = Logger.getLogger(WS3DCreatureControlSystem.class.getName());


    public static void main(String[] args) {
        try {
            ApplicationState.getInstance().handle(
                    new CreateWorldUseCaseInput()
            ).thenAccept(
                    createWorldUseCaseOutput -> launch(args)
            ).join();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane page = FXMLLoader.load(getClass().getResource("gui/main_panel.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("WS3D Creature Control System");
            primaryStage.show();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
