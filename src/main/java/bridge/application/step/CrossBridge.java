package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;
import bridge.domain.bridge.CrossStatus;

import static bridge.domain.bridge.CrossStatus.FAIL;
import static bridge.domain.bridge.CrossStatus.GOING;

public class CrossBridge extends BridgeGameStep {

    protected CrossBridge(BridgeGameContext context, Logger logger) {
        super(context, logger);
    }

    @Override
    protected Step pureExecute() {
        CrossStatus status = context.requestCrossBridge();

        return judgeNextStep(status);
    }

    private Step judgeNextStep(CrossStatus status) {
        if (status == FAIL) {
            return new InputRetry(context, logger);
        }
        if (status == GOING) {
            return new CrossBridge(context, logger);
        }
        return new ShowResult(context, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
