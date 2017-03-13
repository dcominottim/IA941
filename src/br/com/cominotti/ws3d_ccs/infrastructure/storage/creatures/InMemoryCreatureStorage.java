package br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures;

import ws3dproxy.model.Creature;

import java.util.HashMap;

public class InMemoryCreatureStorage implements CreatureStorage {

    private HashMap<String, Creature> map = new HashMap<>();


    @Override
    public synchronized void put(Creature creature) {
        map.put(creature.getName(), creature);
    }

    @Override
    public synchronized Creature get(String creatureName) {
        return map.get(creatureName);
    }
}
