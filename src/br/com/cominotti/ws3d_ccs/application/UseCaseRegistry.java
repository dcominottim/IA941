package br.com.cominotti.ws3d_ccs.application;

import br.com.cominotti.ws3d_ccs.application.commons.EmptyReturn;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating.EatItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.HideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding.UnhideItUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.moving.*;
import br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing.PutInSackUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCaseInput;
import br.com.cominotti.ws3d_ccs.application.world.use_cases.CreateWorldUseCaseOutput;

import java.util.concurrent.CompletableFuture;

/**
 * Created by dancm on 12/03/2017.
 */
public interface UseCaseRegistry {

    CompletableFuture<CreateWorldUseCaseOutput> handle(CreateWorldUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(EatItUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(HideItUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(UnhideItUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(MoveForwardUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(MoveBackwardUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(RotateLeftUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(RotateRightUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(StopUseCaseInput input);

    CompletableFuture<EmptyReturn> handle(PutInSackUseCaseInput input);
}
