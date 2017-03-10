/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cominotti.ws3d_ccs;

import br.com.cominotti.ws3d_ccs.gui.creatures.controls.MoveForwardControl;
import br.com.cominotti.ws3d_ccs.domain.model.world.WorldRegistry;

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
import ws3dproxy.model.Creature;

/**
 * @author ia941
 */
public class WS3DCreatureControlSystem extends Application {

    public static void main(String[] args) {
        WS3DServer.start();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("W3SD Creature Control System Panel");
        StackPane root = new StackPane();
        root.getChildren().add(MoveForwardControl.create(WorldRegistry.getInstance()));
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
