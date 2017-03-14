package br.com.cominotti.ws3d_ccs.application.creatures.use_cases.hiding;

/**
 * Created by dancm on 13/03/2017.
 */
public class HideSingleThingUseCaseInput {

    private final String creatureName;

    private final String thingName;


    public HideSingleThingUseCaseInput(final String creatureName, final String thingName) {
        this.creatureName = creatureName;
        this.thingName = thingName;
    }


    public String getCreatureName() {
        return creatureName;
    }

    public String getThingName() {
        return thingName;
    }
}
