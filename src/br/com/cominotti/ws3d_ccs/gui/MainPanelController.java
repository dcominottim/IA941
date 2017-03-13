package br.com.cominotti.ws3d_ccs.gui;

import br.com.cominotti.ws3d_ccs.application.ApplicationState;
import br.com.cominotti.ws3d_ccs.application.DefaultUseCaseRegistry;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutInSackUseCaseInput;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainPanelController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(MainPanelController.class.getName());

    @FXML
    private ComboBox<String> environmentComboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        environmentComboBox.setItems(
                ApplicationState.getInstance().getObservableFoods()
        );
    }


    public void handleMoveForwardButtonOnMousePressed(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new MoveForwardUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleMoveForwardButtonOnMouseReleased(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new StopUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleRotateLeftOnMousePressed(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new RotateLeftUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleRotateLeftOnMouseReleased(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new StopUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleRotateRightOnMousePressed(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new RotateRightUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleRotateRightOnMouseReleased(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new StopUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleMoveBackwardButtonOnMousePressed(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new MoveBackwardUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleMoveBackwardButtonOnMouseReleased(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new StopUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleEatItButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new EatItUseCaseInput(
                ApplicationState.getInstance().getCreatureName(), environmentComboBox.getValue()
        ));
    }

    public void handlePutInSackButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new PutInSackUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleHideItButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new HideItUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleUnhideItButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new UnhideItUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }
}
