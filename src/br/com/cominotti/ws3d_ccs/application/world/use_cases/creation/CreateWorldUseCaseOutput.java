package br.com.cominotti.ws3d_ccs.application.world.use_cases.creation;

import java.util.HashSet;
import java.util.Set;

public class CreateWorldUseCaseOutput {

    private final String creatureName;

    private final Set<String> foodsNames;


    public CreateWorldUseCaseOutput(final String creatureName, final Set<String> foodsNames) {
        this.creatureName = creatureName;
        this.foodsNames = new HashSet<>(foodsNames);
    }


    public String getCreatureName() {
        return creatureName;
    }

    public Set<String> getFoodsNames() {
        return new HashSet<>(foodsNames);
    }
}
