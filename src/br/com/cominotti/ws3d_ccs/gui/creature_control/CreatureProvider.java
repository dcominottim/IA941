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

import ws3dproxy.model.Creature;

/**
 *
 * @author ia941
 */
public interface CreatureProvider {
    
    Creature getCreature();
}
