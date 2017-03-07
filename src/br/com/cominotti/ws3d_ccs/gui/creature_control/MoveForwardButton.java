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
package br.com.cominotti.ws3d_ccs.gui.creature_control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;
import ws3dproxy.model.WorldPoint;

/**
 *
 * @author ia941
 */
public class MoveForwardButton {
    
    private static final Logger LOGGER = Logger.getLogger(MoveForwardButton.class.getName());
    
    
    private MoveForwardButton() {
        //
    }
    
    
    public static Node createButton(CreatureProvider creatureProvider) {
        final Creature creature = creatureProvider.getCreature();
        final Button button = new Button();
        button.setText("Move Forward");
        button.setOnMouseClicked((MouseEvent event) -> {
            //final WorldPoint creaturePosition = creature.getPosition();
            try {
                creature.start();
                creature.move(2.0, 2.0, 5.0);
                creature.stop();
                LOGGER.info("Moved forward...");
            } catch (CommandExecException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        });
        return button;
    }
}
