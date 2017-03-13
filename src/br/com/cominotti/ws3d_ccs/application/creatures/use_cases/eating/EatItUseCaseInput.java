package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.eating;

public final class EatItUseCaseInput {

    private final String creatureName;

    private final String foodName;


    public EatItUseCaseInput(final String creatureName, final String foodName) {
        this.creatureName = creatureName;
        this.foodName = foodName;
    }


    public String getCreatureName() {
        return creatureName;
    }

    public String getFoodName() {
        return foodName;
    }
}
