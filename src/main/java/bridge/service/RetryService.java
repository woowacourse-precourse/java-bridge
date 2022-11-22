package bridge.service;

import static bridge.constant.Commands.RETRY_COMMAND;

import bridge.domain.Retry;
import java.util.List;

public class RetryService {

    public static final String CANNOT_CROSS_BRIDGE = "X";

    public Retry makeRetry(String command) {
        return new Retry(command);
    }

    public boolean checkRetry(Retry retry) {
        String retryCommand = retry.getRetry();
        if (retryCommand.equals(RETRY_COMMAND)) {
            return true;
        }
        return false;
    }

    public boolean checkSuccessful(List<String>[] bridgeMove) {
        if (bridgeMove[0].contains(CANNOT_CROSS_BRIDGE) || bridgeMove[1].contains(CANNOT_CROSS_BRIDGE)) {
            return false;
        }
        return true;
    }
}
