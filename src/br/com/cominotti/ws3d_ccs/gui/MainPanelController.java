package br.com.cominotti.ws3d_ccs.gui;

import br.com.cominotti.ws3d_ccs.application.ApplicationState;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatAllFoodsInVisionUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatSingleFoodUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.gaming.DeliverLeafletUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.gaming.GenerateLeafletUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.gaming.PrintLeafletsDetailsUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideAllThingsInVisionUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideSingleThingUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideAllThingsInVisionUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideSingleThingUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutAllThingsInVisionInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutSingleThingInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.domain.model.commons.FoodPredicates;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainPanelController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(MainPanelController.class.getName());

    @FXML
    private ComboBox<String> environmentComboBox;

    @FXML
    private Button eatSingleThingButton;

    @FXML
    private Button hideSingleThingButton;

    @FXML
    private Button unhideSingleThingButton;

    @FXML
    private Button putSingleThingInStackButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eatSingleThingButton.setDisable(true);
        hideSingleThingButton.setDisable(true);
        unhideSingleThingButton.setDisable(true);
        putSingleThingInStackButton.setDisable(true);
        environmentComboBox.setItems(
                ApplicationState.getInstance().getObservableThings()
        );
        environmentComboBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    eatSingleThingButton.setDisable(
                            newValue == null || !FoodPredicates.isFoodName().test(newValue)
                    );
                    hideSingleThingButton.setDisable(newValue == null);
                    unhideSingleThingButton.setDisable(newValue == null);
                    putSingleThingInStackButton.setDisable(newValue == null);
                }
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


    public void handleEatAllThingsInVisionButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new EatAllFoodsInVisionUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handlePutAllThingsInVisionInSackButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new PutAllThingsInVisionInSackUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleHideAllThingsInVisionButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new HideAllThingsInVisionUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleUnhideAllThingsInVisionButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new UnhideAllThingsInVisionUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleEatSingleThingButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new EatSingleFoodUseCaseInput(
                ApplicationState.getInstance().getCreatureName(), environmentComboBox.getValue()
        ));
    }

    public void handlePutSingleThingInSackButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new PutSingleThingInSackUseCaseInput(
                ApplicationState.getInstance().getCreatureName(), environmentComboBox.getValue()
        ));
    }

    public void handleHideSingleThingButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new HideSingleThingUseCaseInput(
                ApplicationState.getInstance().getCreatureName(), environmentComboBox.getValue()
        ));
    }

    public void handleUnhideSingleThingButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new UnhideSingleThingUseCaseInput(
                ApplicationState.getInstance().getCreatureName(), environmentComboBox.getValue()
        ));
    }

    public void handleGenLeafletButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new GenerateLeafletUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handlePrintLeafletsButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new PrintLeafletsDetailsUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }

    public void handleDeliverLeafletsButtonOnMouseClicked(MouseEvent mouseEvent) {
        ApplicationState.getInstance().handle(new DeliverLeafletUseCaseInput(
                ApplicationState.getInstance().getCreatureName()
        ));
    }
}
