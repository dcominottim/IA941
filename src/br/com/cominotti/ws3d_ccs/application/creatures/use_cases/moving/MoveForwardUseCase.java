package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;

import java.util.logging.Logger;

public class MoveForwardUseCase implements RunnableUseCase<MoveForwardUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(MoveForwardUseCase.class.getName());

    private final CreatureRepository creatureRepository;


    public MoveForwardUseCase(final CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


    @Override
    public EmptyReturn run(MoveForwardUseCaseInput input) {
        try {
            final Creature creature = creatureRepository.findCreatureByName(input.getCreatureName());
            creature.start();
            creature.move(1.0, 1.0, 1.0);
            creature.updateState();
            LOGGER.info("Moved creature forward...");
            return EmptyReturn.get();
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
