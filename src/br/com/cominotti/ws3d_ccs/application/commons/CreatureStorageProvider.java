package br.com.cominotti.ws3d_ccs.application.commons;

import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.CreatureStorage;

public interface CreatureStorageProvider {

    CreatureStorage getCreatureStorageProvider();
}
