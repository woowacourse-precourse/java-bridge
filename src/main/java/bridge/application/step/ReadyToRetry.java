package bridge.application.step;

import bridge.application.context.BridgeGameContext;

public class ReadyToRetry extends BridgeGameStep {

    protected ReadyToRetry(BridgeGameContext context) {
        super(context);
    }

    @Override
    protected Step pureExecute() {
        context.init();
        return new CrossBridge(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
