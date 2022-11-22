package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;

public class StartGame extends BridgeGameStep {

    public StartGame(final BridgeGameContext context,
                     final Logger logger) {
        super(context, logger);
    }

    @Override
    protected Step pureExecute() {
        context.printStart();
        return new MakeBridge(context, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}