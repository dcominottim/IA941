package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving;


import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;

import java.util.logging.Logger;

public class MoveBackwardUseCase implements RunnableUseCase<MoveBackwardUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(MoveBackwardUseCase.class.getName());

    private final CreatureRepository creatureRepository;


    public MoveBackwardUseCase(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


    @Override
    public EmptyReturn run(MoveBackwardUseCaseInput input) {
        try {
            final Creature creature =  creatureRepository.findCreatureByName(input.getCreatureName());
            creature.start();
            creature.move(-1.0, -1.0, -1.0);
            creature.updateState();
            LOGGER.info("Moved creature backward...");
            return EmptyReturn.get();
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}