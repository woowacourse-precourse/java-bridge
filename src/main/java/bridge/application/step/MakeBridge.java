package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;

public class MakeBridge extends BridgeGameStep {

    protected MakeBridge(final BridgeGameContext context,
                         final Logger logger) {
        super(context, logger);
    }

    @Override
    protected Step pureExecute() {
        context.requestInputBridgeSize();
        return new CrossBridge(context, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}