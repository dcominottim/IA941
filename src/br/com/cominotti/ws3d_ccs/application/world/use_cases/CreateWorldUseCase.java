package br.com.cominotti.ws3d_ccs.application.world.use_cases;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;

import java.util.Collections;
import java.util.logging.Logger;

public final class CreateWorldUseCase implements RunnableUseCase<CreateWorldUseCaseInput, CreateWorldUseCaseOutput> {

    private static final Logger LOGGER = Logger.getLogger(CreateWorldUseCase.class.getName());

    private final WS3DProxy ws3DProxy;

    private final CreatureRepository creatureRepository;


    public CreateWorldUseCase(final WS3DProxy ws3DProxy, final CreatureRepository creatureRepository) {
        this.ws3DProxy = ws3DProxy;
        this.creatureRepository = creatureRepository;
    }


    @Override
    public CreateWorldUseCaseOutput run(CreateWorldUseCaseInput input) {
        try {
            ws3DProxy.getWorld().reset();
            World.createFood(0, 150, 159);
            final Creature creature = ws3DProxy.createCreature();
            creatureRepository.saveCreature(creature);
            LOGGER.info("Finished Create World...");
            return new CreateWorldUseCaseOutput(creature.getName(), Collections.emptySet());
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
