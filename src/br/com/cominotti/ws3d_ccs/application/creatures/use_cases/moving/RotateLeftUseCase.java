package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;

import java.util.logging.Logger;

public class RotateLeftUseCase implements RunnableUseCase<RotateLeftUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(RotateLeftUseCase.class.getName());

    private final CreatureRepository creatureRepository;


    public RotateLeftUseCase(final CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


    @Override
    public EmptyReturn run(final RotateLeftUseCaseInput input) {
        try {
            final Creature creature = creatureRepository.findCreatureByName(input.getCreatureName());
            creature.start();
            creature.rotate(-1.0);
            creature.updateState();
            LOGGER.info("Rotated creature to the left...");
            return EmptyReturn.get();
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
