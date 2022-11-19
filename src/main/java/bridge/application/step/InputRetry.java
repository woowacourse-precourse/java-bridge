package bridge.application.step;

import bridge.application.context.BridgeGameContext;
import bridge.domain.command.GameCommand;

import static bridge.domain.command.GameCommand.RETRY;

public class InputRetry extends BridgeGameStep {

    protected InputRetry(BridgeGameContext context) {
        super(context);
    }

    @Override
    public Step pureExecute() {
        GameCommand gameCommand = context.requestInputRetry();

        return judgeNext(gameCommand);
    }

    private Step judgeNext(GameCommand command) {
        if (command == RETRY) {
            return new ReadyToRetry(context);
        }
        return new ShowResult(context);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
