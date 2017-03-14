package br.com.cominotti.ws3d_ccs.application;


import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatAllFoodsInVisionUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatAllFoodsInVisionUseCaseOutput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatSingleFoodUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.gaming.DeliverLeafletUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.gaming.GenerateLeafletUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.gaming.PrintLeafletsDetailsUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideAllThingsInVisionUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideSingleThingUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideAllThingsInVisionUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideSingleThingUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutAllThingsInVisionInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutAllThingsInVisionInSackUseCaseOutput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutSingleThingInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.creation.CreateWorldUseCaseOutput;
import br.com.cominotti.ws3d_ccs.domain.model.commons.FoodPredicates;
import br.com.cominotti.ws3d_ccs.domain.model.commons.TerminalLeafletPrinter;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.creatures.InMemoryCreatureRepository;
import br.com.cominotti.ws3d_ccs.infrastructure.storage.things.InMemoryThingRepository;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public final class ApplicationState implements UseCaseRegistry {

    private static final ApplicationState SINGLETON = new ApplicationState();

    private final UseCaseRegistry useCaseRegistry;

    private String creatureName;

    private ObservableList<String> observableThings;


    private ApplicationState() {
        this.useCaseRegistry = new DefaultUseCaseRegistry(
                new InMemoryCreatureRepository(),
                new InMemoryThingRepository(),
                new TerminalLeafletPrinter()
        );
    }


    public static ApplicationState getInstance() {
        return SINGLETON;
    }


    public String getCreatureName() {
        return creatureName;
    }

    public ObservableList<String> getObservableThings() {
        return new ReadOnlyListWrapper<>(observableThings);
    }

    @Override
    public CompletableFuture<CreateWorldUseCaseOutput> handle(final CreateWorldUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                createWorldUseCaseOutput -> {
                    creatureName = createWorldUseCaseOutput.getCreatureName();
                    observableThings = FXCollections.observableList(
                            createWorldUseCaseOutput.getObjectsNames()
                    );
                    return createWorldUseCaseOutput;
                }
        );
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final EatSingleFoodUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                emptyReturn -> {
                    Platform.runLater(
                            () -> observableThings.remove(input.getFoodName())
                    );
                    return emptyReturn;
                }
        );
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final HideAllThingsInVisionUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final HideSingleThingUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final UnhideAllThingsInVisionUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final UnhideSingleThingUseCaseInput input) {
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
    public CompletableFuture<EatAllFoodsInVisionUseCaseOutput> handle(final EatAllFoodsInVisionUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                eatAllFoodsInVisionUseCaseOutput -> {
                    Platform.runLater(
                            () -> observableThings.removeAll(
                                    eatAllFoodsInVisionUseCaseOutput.getEatenFoods()
                            )
                    );
                    return eatAllFoodsInVisionUseCaseOutput;
                }
        );
    }

    @Override
    public CompletableFuture<PutAllThingsInVisionInSackUseCaseOutput> handle(final PutAllThingsInVisionInSackUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                putAllThingsInVisionInSackUseCaseOutput -> {
                    Platform.runLater(
                            () -> observableThings.removeAll(
                                    putAllThingsInVisionInSackUseCaseOutput.getStoredThings().stream().filter(
                                            FoodPredicates.isNotFoodName()
                                    ).collect(
                                            Collectors.toList()
                                    )
                            )
                    );
                    return putAllThingsInVisionInSackUseCaseOutput;
                }
        );
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(final PutSingleThingInSackUseCaseInput input) {
        return useCaseRegistry.handle(input).thenApply(
                emptyReturn -> {
                    Platform.runLater(
                            () -> observableThings.remove(
                                    input.getThingName()
                            )
                    );
                    return emptyReturn;
                }
        ).exceptionally(
                throwable -> null
        );
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(GenerateLeafletUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(PrintLeafletsDetailsUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }

    @Override
    public CompletableFuture<EmptyReturn> handle(DeliverLeafletUseCaseInput input) {
        return useCaseRegistry.handle(input);
    }
}
