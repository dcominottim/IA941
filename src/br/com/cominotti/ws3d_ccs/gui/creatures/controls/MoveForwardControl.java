/*
 * Copyright 2017 ia941.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.cominotti.ws3d_ccs.gui.creatures.controls;

import br.com.cominotti.ws3d_ccs.domain.model.CreatureProvider;
import br.com.cominotti.ws3d_ccs.domain.model.creatures.actions.MoveForwardAction;
import br.com.cominotti.ws3d_ccs.domain.model.creatures.actions.StopAction;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;

public class MoveForwardControl {

    private MoveForwardControl() {
        //
    }


    public static Node create(CreatureProvider creatureProvider) {
        final MoveForwardAction moveForwardAction = new MoveForwardAction(creatureProvider);
        final StopAction stopAction = new StopAction(creatureProvider);
        final Button button = new Button();
        button.setText("Move Forward");
        button.setOnMousePressed(event -> moveForwardAction.execute());
        button.setOnMouseReleased(event -> stopAction.execute());
        return button;
    }
}
