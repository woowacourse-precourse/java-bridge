package bridge.application.step;

import bridge.application.context.BridgeGameContext;

public abstract class BridgeGameStep implements Step {

    protected final BridgeGameContext context;

    protected BridgeGameStep(BridgeGameContext context) {
        this.context = context;
    }

    @Override
    public Step execute() {
        while (true) {
            try {
                return pureExecute();
            } catch (IllegalArgumentException e) {

            }
        }
    }

    abstract protected Step pureExecute();
}
