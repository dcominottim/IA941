package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.storing;

/**
 * Created by dancm on 12/03/2017.
 */
public class PutInSackUseCaseInput {

    private final String creatureName;


    public PutInSackUseCaseInput(final String creatureName) {
        this.creatureName = creatureName;
    }


    public String getCreatureName() {
        return creatureName;
    }
}
