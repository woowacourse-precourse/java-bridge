package bridge.application.step;

import bridge.application.context.BridgeGameContext;

public class Exit extends BridgeGameStep {

    private static final String CANNOT_EXECUTED_STATE = "실행되면 안되는 상태입니다.";

    protected Exit(BridgeGameContext context) {
        super(context);
    }

    @Override
    protected Step pureExecute() {
        throw new IllegalStateException(CANNOT_EXECUTED_STATE);
    }

    @Override
    public boolean executable() {
        return false;
    }
}
