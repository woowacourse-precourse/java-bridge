package bridge.application.step;

import bridge.application.context.BridgeGameContext;

public class ShowResult extends BridgeGameStep {

    protected ShowResult(BridgeGameContext context) {
        super(context);
    }

    @Override
    protected Step pureExecute() {
        context.showResult();
        return new Exit(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}