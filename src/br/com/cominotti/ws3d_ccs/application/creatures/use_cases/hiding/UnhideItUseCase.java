package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;

import java.util.ArrayList;
import java.util.logging.Logger;

public class UnhideItUseCase implements RunnableUseCase<UnhideItUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(UnhideItUseCase.class.getName());

    private final CreatureRepository creatureRepository;


    public UnhideItUseCase(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


    @Override
    public EmptyReturn run(UnhideItUseCaseInput input) {
        try {
            final Creature creature = creatureRepository.findCreatureByName(input.getCreatureName());
            if (creature.getThingsInVision() != null && !creature.getThingsInVision().isEmpty()) {
                for (Thing thing : new ArrayList<>(creature.getThingsInVision())) {
                    creature.unhideIt(thing.getName());
                    LOGGER.info("Unhid thing " + thing.getName() + " ...");
                }
                creature.updateState();
            }
            LOGGER.info("Finished Unhide It action...");
            return EmptyReturn.get();
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }


}
