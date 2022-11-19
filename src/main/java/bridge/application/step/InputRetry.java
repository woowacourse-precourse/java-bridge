package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.application.log.Logger;
import bridge.domain.command.GameCommand;

import static bridge.domain.command.GameCommand.RETRY;

public class InputRetry extends BridgeGameStep {

    protected InputRetry(final BridgeGameContext context,
                         final Logger logger) {
        super(context, logger);
    }

    @Override
    public Step pureExecute() {
        GameCommand gameCommand = context.requestInputRetry();

        return judgeNext(gameCommand);
    }

    private Step judgeNext(final GameCommand command) {
        if (command == RETRY) {
            return new ReadyToRetry(context, logger);
        }
        return new ShowResult(context, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
