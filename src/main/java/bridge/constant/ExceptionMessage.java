package bridge.constant;

import bridge.utils.BridgeGameCommand;
import bridge.utils.BridgeSizeRange;
import bridge.utils.BridgeStep;

public enum ExceptionMessage {
    BRIDGE_RANGE(" %d ~ %d 사이의 숫자를 입력해야 합니다.",
            BridgeSizeRange.MIN_BRIDGE_SIZE.getBridgeSize(),
            BridgeSizeRange.MAX_BRIDGE_SIZE.getBridgeSize()),
    MOVE(" 이동 입력은 대문자 %s 혹은 대문자 %s 만 가능합니다.",
            BridgeStep.UP.getStep(),
            BridgeStep.DOWN.getStep()
    ),
    RETRY_INPUT(" 재시작 입력은 대문자 %s 혹은 대문자 %s 만 가능합니다.",
            BridgeGameCommand.RETRY.getCommand(),
            BridgeGameCommand.QUIT.getCommand());

    private final String message;

    ExceptionMessage(String message, Object... replacers) {
        this.message = String.format(message, replacers);
    }

    public String getMessage() {
        String baseErrorMessage = "[ERROR]";
        return baseErrorMessage + message;
    }
}
