package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;

public class ShowResult extends BridgeGameStep {

    protected ShowResult(BridgeGameContext context, Logger logger) {
        super(context, logger);
    }

    @Override
    protected Step pureExecute() {
        context.showResult();
        return new Exit(context, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}