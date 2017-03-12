package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating;

public final class EatItUseCaseInput {

    private final String creatureName;


    public EatItUseCaseInput(final String creatureName) {
        this.creatureName = creatureName;
    }


    public String getCreatureName() {
        return creatureName;
    }
}
