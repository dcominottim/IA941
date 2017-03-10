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
package br.com.cominotti.ws3d_ccs.domain.model.world;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.cominotti.ws3d_ccs.domain.model.CreatureProvider;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;

/**
 *
 * @author ia941
 */
public class WorldRegistry implements CreatureProvider {
    
    private static final WS3DProxy WS3D_PROXY = new WS3DProxy();
    
    private static final WorldRegistry INSTANCE = new WorldRegistry();
    
    private final Creature CREATURE;
    
    
    private WorldRegistry() {
        try {
            WS3D_PROXY.getWorld().reset();
            World.createFood(0, 150, 159);
            this.CREATURE = WS3D_PROXY.createCreature();
        } catch (CommandExecException ex) {
            Logger.getLogger(WorldRegistry.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new RuntimeException();
        }
    }
    
    
    public static WorldRegistry getInstance() {
        return INSTANCE;
    }

    
    @Override
    public Creature getCreature() {
        return this.CREATURE;
    }
    
}