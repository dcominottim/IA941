package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding;

/**
 * Created by dancm on 12/03/2017.
 */
public class UnhideItUseCaseInput {

    private final String creatureName;


    public UnhideItUseCaseInput(final String creatureName) {
        this.creatureName = creatureName;
    }


    public String getCreatureName() {
        return creatureName;
    }
}
