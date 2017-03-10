package br.com.cominotti.ws3d_ccs.domain.model.creatures.actions;

import br.com.cominotti.ws3d_ccs.domain.model.CreatureProvider;
import br.com.cominotti.ws3d_ccs.domain.model.ExecutableAction;
import ws3dproxy.CommandExecException;

import java.util.logging.Logger;

public class MoveForwardAction implements ExecutableAction {

    private static final Logger LOGGER = Logger.getLogger(MoveForwardAction.class.getName());

    private final CreatureProvider CREATURE_PROVIDER;


    public MoveForwardAction(final CreatureProvider creatureProvider) {
        this.CREATURE_PROVIDER = creatureProvider;
    }


    @Override
    public void execute() {
        try {
            CREATURE_PROVIDER.getCreature().start();
            CREATURE_PROVIDER.getCreature().move(1.0, 1.0, 1.0);
            LOGGER.info("Moved creature forward...");
        } catch (CommandExecException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }
}
