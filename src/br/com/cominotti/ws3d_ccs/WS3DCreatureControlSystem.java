/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cominotti.ws3d_ccs;

import br.com.cominotti.ws3d_ccs.gui.creature_control.MoveForwardButton;
import br.com.cominotti.ws3d_ccs.gui.creature_control.WorldRegistry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;

/**
 * @author ia941
 */
public class WS3DCreatureControlSystem extends Application {

    private static Creature creature;

    public static void main(String[] args) throws CommandExecException {
        try {
            Executors.newSingleThreadExecutor().submit(() -> {
                worldserver3d.Main.main(null);
            });

        } catch (Exception ex) {
            Logger.getLogger(WS3DCreatureControlSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WorldRegistry worldRegistry = WorldRegistry.getInstance();

        launch(args);
        Logger.getLogger(WS3DCreatureControlSystem.class.getName()).log(Level.SEVERE, null, "hey");

    }

    @Override
    public void start(Stage primaryStage) throws CommandExecException {
        primaryStage.setTitle("W3SD Creature Control System Panel");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });


        StackPane root = new StackPane();
        root.getChildren().add(MoveForwardButton.createButton(WorldRegistry.getInstance()));
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
