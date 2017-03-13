package br.com.cominotti.ws3d_ccs.application;


import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseOutput;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.InMemoryCreatureRepository;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.InMemoryCreatureStorage;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.foods.InMemoryFoodRepository;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.foods.InMemoryFoodStorage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class ApplicationState implements UseCaseRegistry {

    private static final ApplicationState SINGLETON = new ApplicationState();

    private final UseCaseRegistry useCaseRegistry;

    private String creatureName;

    private Set<String> foodsNames;

    private ObservableList<String> observableFoods;


    private ApplicationState() {
        this.useCaseRegistry = new DefaultUseCaseRegistry(
                new InMemoryCreatureRepository(
                        new InMemoryCreatureStorage()
                ),
                new InMemoryFoodRepository(
                        new InMemoryFoodStorage()
                )
        );
    }


    public static ApplicationState getInstance() {
        return SINGLETON;
    }


    public String getCreatureName() {
        return creatureName;
    }

    public ObservableList<String> getObservableFoods() {
        return observableFoods;
    }

    @Override
    public CompletableFuture<CreateWorldUseCaseOutput> handle(final CreateWorldUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                createWorldUseCaseOutput -> {
                    creatureName = createWorldUseCaseOutput.getCreatureName();
                    foodsNames = createWorldUseCaseOutput.getFoodsNames();
                    observableFoods = FXCollections.observableList(
                            new ArrayList<>(createWorldUseCaseOutput.getFoodsNames())
                    );
                    return createWorldUseCaseOutput;
                }
        );
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final EatItUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                emptyReturn -> {
                    Platform.runLater(
                            () -> observableFoods.remove(input.getFoodName())
                    );
                    return emptyReturn;
                }
        );
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final HideItUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final UnhideItUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final MoveForwardUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final MoveBackwardUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final RotateLeftUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final RotateRightUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final StopUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final PutInSackUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }
}
