package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;

public abstract class BridgeGameStep implements Step {

    protected final BridgeGameContext context;
    protected final Logger logger;

    protected BridgeGameStep(
            final BridgeGameContext context,
            final Logger logger
    ) {
        this.context = context;
        this.logger = logger;
    }

    @Override
    public Step execute() {
        while (true) {
            try {
                return pureExecute();
            } catch (RuntimeException e) {
                logger.error(e.getMessage());
            }
        }
    }

    abstract protected Step pureExecute();
}
