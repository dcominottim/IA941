package br.com.cominotti.ws3d_ccs.application;

import java.util.concurrent.CompletableFuture;

public class AsyncUseCaseRunner implements UseCaseRunner {

    private static final AsyncUseCaseRunner ASYNC_USE_CASE_RUNNER = new AsyncUseCaseRunner();


    private AsyncUseCaseRunner() {
        //
    }


    public static AsyncUseCaseRunner getInstance() {
        return ASYNC_USE_CASE_RUNNER;
    }


    @Override
    public <TInput, TOutput> CompletableFuture<TOutput> run(RunnableUseCase<TInput, TOutput> runnableUseCase, TInput useCaseInput) {
        return CompletableFuture.supplyAsync(
                () -> runnableUseCase.run(useCaseInput)
        );
    }
}