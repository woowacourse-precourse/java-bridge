package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.domain.bridge.CrossStatus;

import static bridge.domain.bridge.CrossStatus.FAIL;
import static bridge.domain.bridge.CrossStatus.GOING;

public class CrossBridge extends BridgeGameStep {

    protected CrossBridge(BridgeGameContext context) {
        super(context);
    }

    @Override
    protected Step pureExecute() {
        CrossStatus status = context.requestCrossBridge();

        return judgeNextStep(status);
    }

    private Step judgeNextStep(CrossStatus status) {
        if (status == FAIL) {
            return new InputRetry(context);
        }
        if (status == GOING) {
            return new CrossBridge(context);
        }
        return new ShowResult(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
