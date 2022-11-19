package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;

public class ReadyToRetry extends BridgeGameStep {

    protected ReadyToRetry(BridgeGameContext context, Logger logger) {
        super(context, logger);
    }

    @Override
    protected Step pureExecute() {
        context.retry();
        return new CrossBridge(context, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
