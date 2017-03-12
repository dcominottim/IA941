package br.com.cominotti.ws3d_ccs.application;

import br.com.cominotti.ws3d_ccs.application.commons.CreatureRepository;
import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatItUseCase;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideItUseCase;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideItUseCase;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutInSackUseCase;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCase;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCaseOutput;
import ws3dproxy.WS3DProxy;

import java.util.concurrent.CompletableFuture;

public class DefaultUseCaseRegistry implements UseCaseRegistry {

    private final UseCaseRunner useCaseRunner;

    private final CreateWorldUseCase createWorldUseCase;

    private final EatItUseCase eatItUseCase;

    private final HideItUseCase hideItUseCase;

    private final UnhideItUseCase unhideItUseCase;

    private final MoveForwardUseCase moveForwardUseCase;

    private final MoveBackwardUseCase moveBackwardUseCase;

    private final RotateLeftUseCase rotateLeftUseCase;

    private final RotateRightUseCase rotateRightUseCase;

    private final StopUseCase stopUseCase;

    private final PutInSackUseCase putInSackUseCase;


    public DefaultUseCaseRegistry(final WS3DProxy ws3DProxy, final CreatureRepository creatureRepository) {
        this.useCaseRunner = AsyncUseCaseRunner.getInstance();
        this.createWorldUseCase = new CreateWorldUseCase(ws3DProxy, creatureRepository);
        this.eatItUseCase = new EatItUseCase(creatureRepository);
        this.hideItUseCase = new HideItUseCase(creatureRepository);
        this.unhideItUseCase = new UnhideItUseCase(creatureRepository);
        this.moveForwardUseCase = new MoveForwardUseCase(creatureRepository);
        this.moveBackwardUseCase = new MoveBackwardUseCase(creatureRepository);
        this.rotateLeftUseCase = new RotateLeftUseCase(creatureRepository);
        this.rotateRightUseCase = new RotateRightUseCase(creatureRepository);
        this.stopUseCase = new StopUseCase(creatureRepository);
        this.putInSackUseCase = new PutInSackUseCase(creatureRepository);
    }


    @Override
    public CompletableFuture<CreateWorldUseCaseOutput> handle(CreateWorldUseCaseInput input) {
        return useCaseRunner.run(createWorldUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(EatItUseCaseInput input) {
        return useCaseRunner.run(eatItUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(HideItUseCaseInput input) {
        return useCaseRunner.run(hideItUseCase, input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(UnhideItUseCaseInput input) {
        return useCaseRunner.run(unhideItUseCase, input);
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
    public CompletableFuture<EmptyReturn> handle(PutInSackUseCaseInput input) {
        return useCaseRunner.run(putInSackUseCase, input);
    }
}
