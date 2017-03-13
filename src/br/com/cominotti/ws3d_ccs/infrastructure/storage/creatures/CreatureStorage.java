package br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures;

import ws3dproxy.model.Creature;

public interface CreatureStorage {

    void put(Creature creature);

    Creature get(String creatureName);
}
