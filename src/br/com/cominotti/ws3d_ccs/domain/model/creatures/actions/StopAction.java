package br.com.cominotti.ws3d_ccs.domain.model.creatures.actions;

import br.com.cominotti.ws3d_ccs.domain.model.CreatureProvider;
import br.com.cominotti.ws3d_ccs.domain.model.ExecutableAction;
import ws3dproxy.CommandExecException;

import java.util.logging.Logger;

public class StopAction implements ExecutableAction {

    private static final Logger LOGGER = Logger.getLogger(StopAction.class.getName());

    private final CreatureProvider CREATURE_PROVIDER;


    public StopAction(final CreatureProvider creatureProvider) {
        this.CREATURE_PROVIDER = creatureProvider;
    }


    @Override
    public void execute() {
        try {
            CREATURE_PROVIDER.getCreature().stop();
            LOGGER.info("Moved creature forward...");
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }
}
