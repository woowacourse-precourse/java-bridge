package bridge.application.step;

import bridge.application.context.BridgeGameContext;

public class MakeBridge extends BridgeGameStep {

    protected MakeBridge(BridgeGameContext context) {
        super(context);
    }

    @Override
    protected Step pureExecute() {
        context.requestInputBridgeSize();
        return new CrossBridge(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}