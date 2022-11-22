package bridge.exception.domain;

import bridge.exception.BridgeException;

public class NoSuchGameCommandException extends BridgeException {
    private static final String NO_SUCH_GAME_COMMAND_EXCEPTION_MESSAGE = "%s에 해당하는 GameCommand 가 존재하지 않습니다.";

    public NoSuchGameCommandException(String command) {
        super(String.format(NO_SUCH_GAME_COMMAND_EXCEPTION_MESSAGE, command));
    }
}
