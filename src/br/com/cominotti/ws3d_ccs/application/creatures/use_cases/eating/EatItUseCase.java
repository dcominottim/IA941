package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import br.com.cominotti.ws3d_ccs.application.commons.FoodRepository;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;

import java.util.logging.Logger;

public final class EatItUseCase implements RunnableUseCase<EatItUseCaseInput, EmptyReturn> {

    private static final Logger LOGGER = Logger.getLogger(EatItUseCase.class.getName());

    private final CreatureRepository creatureRepository;

    private final FoodRepository foodRepository;


    public EatItUseCase(final CreatureRepository creatureRepository, final FoodRepository foodRepository) {
        this.creatureRepository = creatureRepository;
        this.foodRepository = foodRepository;
    }


    @Override
    public EmptyReturn run(final EatItUseCaseInput input) {
        try {
            final Creature creature = creatureRepository.findCreatureByName(input.getCreatureName());
            creature.eatIt(input.getFoodName());
            creature.updateState();
            foodRepository.removeFood(input.getFoodName());
            LOGGER.info("Ate food " + input.getFoodName() + "...");
        } catch (CommandExecException e) {
            LOGGER.severe(e.getMessage());
            throw new RuntimeException();
        }
        foodRepository.findAllFoods().forEach(
                food -> {

                }
        );
//            if (creature.getThingsInVision() != null && !creature.getThingsInVision().isEmpty()) {
//                for (Thing thing : creature.getThingsInVision()) {
//                    creature.eatIt(thing.getName());
//                    creature.updateState();
//                    LOGGER.info("Ate thing " + thing.getName() + " ...");
//                }
//            }
        LOGGER.info("Finished Eat It action...");
        return EmptyReturn.get();
    }
}
