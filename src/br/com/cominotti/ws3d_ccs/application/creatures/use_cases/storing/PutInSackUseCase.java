package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PutInSackUseCase implements RunnableUseCase<PutInSackUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(PutInSackUseCase.class.getName());

    private final CreatureRepository creatureRepository;


    public PutInSackUseCase(final CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


    @Override
    public EmptyReturn run(PutInSackUseCaseInput input) {
        try {
            final Creature creature = creatureRepository.findCreatureByName(input.getCreatureName());
            if (creature.getThingsInVision() != null && !creature.getThingsInVision().isEmpty()) {
                for (Thing thing : new ArrayList<>(creature.getThingsInVision())) {
                    creature.putInSack(thing.getName());
                    creature.updateBag();
                    creature.updateState();
                    LOGGER.info("Put thing " + thing.getName() + " in the sack...");
                }
            }
            LOGGER.info("Finished Put In Sack action...");
            return EmptyReturn.get();
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
