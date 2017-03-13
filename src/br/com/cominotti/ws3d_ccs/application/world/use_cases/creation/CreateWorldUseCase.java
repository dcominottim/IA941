package br.com.cominotti.ws3d_ccs.application.world.use_cases.creation;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.RunnableUseCase;
import br.com.cominotti.ws3d_ccs.application.commons.FoodRepository;
import br.com.cominotti.ws3d_ccs.domain.model.commons.FoodPredicates;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Thing;
import ws3dproxy.model.World;
import ws3dproxy.util.Constants;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class CreateWorldUseCase implements RunnableUseCase<CreateWorldUseCaseInput, CreateWorldUseCaseOutput> {

    private static final Logger LOGGER = Logger.getLogger(CreateWorldUseCase.class.getName());

    private final CreatureRepository creatureRepository;

    private final FoodRepository foodRepository;


    public CreateWorldUseCase(final CreatureRepository creatureRepository, final FoodRepository foodRepository) {
        this.creatureRepository = creatureRepository;
        this.foodRepository = foodRepository;
    }


    @Override
    public CreateWorldUseCaseOutput run(final CreateWorldUseCaseInput input) {
        try {
            Executors.newSingleThreadExecutor().submit(
                    () -> worldserver3d.Main.main(null)
            );
            Thread.sleep(6000);
            final WS3DProxy ws3DProxy = new WS3DProxy(input.getHost(), input.getPort());
            ws3DProxy.getWorld().reset();
            World.createFood(0, 150, 150);
            World.createJewel(0, 300, 300);
            World.createCage(450, 350);
            World.getWorldEntities().stream().filter(
                    FoodPredicates.isFood()
            ).forEach(
                    foodRepository::saveFood
            );
            final Creature creature = ws3DProxy.createCreature();
            creatureRepository.saveCreature(creature);
            LOGGER.info("Finished Create World...");
            return new CreateWorldUseCaseOutput(
                    creature.getName(),
                    foodRepository.findAllFoods().stream().map(
                            Thing::getName
                    ).collect(
                            Collectors.toSet()
                    )
            );
        } catch (CommandExecException | InterruptedException ex) {
            LOGGER.severe(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
