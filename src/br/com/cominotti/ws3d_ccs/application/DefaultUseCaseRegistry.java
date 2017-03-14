package br.com.cominotti.ws3d_ccs.application;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.commons.ThingRepository;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutAllThingsInVisionInSackUseCase;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutAllThingsInVisionInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutSingleThingInSackUseCase;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutSingleThingInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCase;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseOutput;

import java.util.concurrent.CompletableFuture;

public class DefaultUseCaseRegistry implements UseCaseRegistry {

    private final UseCaseRunner useCaseRunner;

    private final CreateWorldUseCase createWorldUseCase;

    private final EatAllFoodsInVisionUseCase eatAllFoodsInVisionUseCase;

    private final EatSingleFoodUseCase eatSingleFoodUseCase;

    private final HideAllThingsInVisionUseCase hideAllThingsInVisionUseCase;

    private final HideSingleThingUseCase hideSingleThingUseCase;

    private final UnhideAllThingsInVisionUseCase unhideAllThingsInVisionUseCase;

    private final UnhideSingleThingUseCase unhideSingleThingUseCase;

    private final MoveForwardUseCase moveForwardUseCase;

    private final MoveBackwardUseCase moveBackwardUseCase;

    private final RotateLeftUseCase rotateLeftUseCase;

    private final RotateRightUseCase rotateRightUseCase;

    private final StopUseCase stopUseCase;

    private final PutAllThingsInVisionInSackUseCase putAllThingsInVisionInSackUseCase;

    private final PutSingleThingInSackUseCase putSingleThingInSackUseCase;


    public DefaultUseCaseRegistry(final CreatureRepository creatureRepository, final ThingRepository thingRepository) {
        this.useCaseRunner = AsyncUseCaseRunner.getInstance();
        this.createWorldUseCase = new CreateWorldUseCase(creatureRepository, thingRepository);
        this.moveForwardUseCase = new MoveForwardUseCase(creatureRepository);
        this.moveBackwardUseCase = new MoveBackwardUseCase(creatureRepository);
        this.rotateLeftUseCase = new RotateLeftUseCase(creatureRepository);
        this.rotateRightUseCase = new RotateRightUseCase(creatureRepository);
        this.stopUseCase = new StopUseCase(creatureRepository);
        this.eatAllFoodsInVisionUseCase = new EatAllFoodsInVisionUseCase(creatureRepository, thingRepository);
        this.eatSingleFoodUseCase = new EatSingleFoodUseCase(creatureRepository, thingRepository);
        this.hideAllThingsInVisionUseCase = new HideAllThingsInVisionUseCase(creatureRepository);
        this.hideSingleThingUseCase = new HideSingleThingUseCase(creatureRepository);
        this.unhideAllThingsInVisionUseCase = new UnhideAllThingsInVisionUseCase(creatureRepository);
        this.unhideSingleThingUseCase = new UnhideSingleThingUseCase(creatureRepository);
        this.putAllThingsInVisionInSackUseCase = new PutAllThingsInVisionInSackUseCase(creatureRepository);
        this.putSingleThingInSackUseCase = new PutSingleThingInSackUseCase(creatureRepository);
    }


    @Override
    public CompletableFuture<CreateWorldUseCaseOutput> handle(CreateWorldUseCaseInput input) {
        return useCaseRunner.run(createWorldUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(MoveForwardUseCaseInput input) {
        return useCaseRunner.run(moveForwardUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(MoveBackwardUseCaseInput input) {
        return useCaseRunner.run(moveBackwardUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(RotateLeftUseCaseInput input) {
        return useCaseRunner.run(rotateLeftUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(RotateRightUseCaseInput input) {
        return useCaseRunner.run(rotateRightUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(StopUseCaseInput input) {
        return useCaseRunner.run(stopUseCase, input);
    }

    @Override
    public CompletableFuture<EatAllFoodsInVisionUseCaseOutput> handle(EatAllFoodsInVisionUseCaseInput input) {
        return useCaseRunner.run(eatAllFoodsInVisionUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(EatSingleFoodUseCaseInput input) {
        return useCaseRunner.run(eatSingleFoodUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(HideAllThingsInVisionUseCaseInput input) {
        return useCaseRunner.run(hideAllThingsInVisionUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(HideSingleThingUseCaseInput input) {
        return useCaseRunner.run(hideSingleThingUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(UnhideAllThingsInVisionUseCaseInput input) {
        return useCaseRunner.run(unhideAllThingsInVisionUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(UnhideSingleThingUseCaseInput input) {
        return useCaseRunner.run(unhideSingleThingUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(PutAllThingsInVisionInSackUseCaseInput input) {
        return useCaseRunner.run(putAllThingsInVisionInSackUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(PutSingleThingInSackUseCaseInput input) {
        return useCaseRunner.run(putSingleThingInSackUseCase, input);
    }
}
