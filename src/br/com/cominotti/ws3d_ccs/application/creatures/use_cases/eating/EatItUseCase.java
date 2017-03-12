package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepositoryProvider;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

import java.util.logging.Logger;

public final class EatItUseCase implements RunnableUseCase<EatItUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(EatItUseCase.class.getName());

    private final CreatureRepository creatureRepository;


    public EatItUseCase(final CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


    @Override
    public EmptyReturn run(EatItUseCaseInput input) {
        try {
            final Creature creature = creatureRepository.findCreatureByName(input.getCreatureName());
            if (creature.getThingsInVision() != null && !creature.getThingsInVision().isEmpty()) {
                for (Thing thing : creature.getThingsInVision()) {
                    creature.eatIt(thing.getName());
                    creature.updateState();
                    LOGGER.info("Ate thing " + thing.getName() + " ...");
                }
            }
            LOGGER.info("Finished Eat It action...");
            return EmptyReturn.get();
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
