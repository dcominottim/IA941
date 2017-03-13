package br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.CreatureStorage;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.InMemoryCreatureStorage;
import ws3dproxy.model.Creature;

public class InMemoryCreatureRepository implements CreatureRepository {

    private final InMemoryCreatureStorage creatureStorage;


    public InMemoryCreatureRepository(final InMemoryCreatureStorage creatureStorage) {
        this.creatureStorage = creatureStorage;
    }


    @Override
    public Creature findCreatureByName(String creatureName) {
        return creatureStorage.get(creatureName);
    }

    @Override
    public void saveCreature(Creature creature) {
        creatureStorage.put(creature);
    }
}
