package br.com.cominotti.ws3d_ccs.application;


import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCaseOutput;
import br.com.cominotti.ws3d_ccs.infrastructure.repositories.creatures.InMemoryCreatureRepository;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.InMemoryCreatureStorage;
import ws3dproxy.WS3DProxy;

import java.util.concurrent.CompletableFuture;

public final class ApplicationState implements UseCaseRegistry {

    private static final ApplicationState SINGLETON = new ApplicationState();

    private final UseCaseRegistry useCaseRegistry;

    private String creatureName;


    private ApplicationState() {
        this.useCaseRegistry = new DefaultUseCaseRegistry(
                new WS3DProxy(),
                new InMemoryCreatureRepository(
                        new InMemoryCreatureStorage()
                )
        );
    }


    public static ApplicationState getInstance() {
        return SINGLETON;
    }


    public String getCreatureName() {
        return creatureName;
    }

    @Override
    public CompletableFuture<CreateWorldUseCaseOutput> handle(CreateWorldUseCaseInput input) {
        CompletableFuture<CreateWorldUseCaseOutput> result = useCaseRegistry.handle(input);
        result.thenApply(
                createWorldUseCaseOutput ->
                        creatureName = createWorldUseCaseOutput.getCreatureName()
        );
        return result;
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(EatItUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(HideItUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(UnhideItUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(MoveForwardUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(MoveBackwardUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(RotateLeftUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(RotateRightUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(StopUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(PutInSackUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }
}
