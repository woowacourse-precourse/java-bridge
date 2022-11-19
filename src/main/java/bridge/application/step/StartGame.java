package bridge.application.step;

import bridge.application.context.BridgeGameContext;

public class StartGame extends BridgeGameStep {

    public StartGame(BridgeGameContext context) {
        super(context);
    }

    @Override
    protected Step pureExecute() {
        context.printStart();
        return new MakeBridge(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}