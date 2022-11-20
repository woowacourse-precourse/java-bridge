package bridge.systemMessage;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.Bridge;

public enum ErrorMessage {

    INPUT_IS_EMPTY_ERROR("입력 값이 없습니다."),
    NOT_VALID_INPUT_TYPE_ERROR("다리 길이는 숫자만 입력 가능합니다."),
    NOT_VALID_SIZE_ERROR(
            String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                    Bridge.getBridgeMinSize(),
                    Bridge.getBridgeMaxSize())
    ),
    NOT_VALID_MOVING_INPUT_ERROR(
            String.format("이동할 칸은 %s 또는 %s만 입력 가능합니다.",
                    BridgeMaker.getUpBridgeLetter(),
                    BridgeMaker.getDownBridgeLetter())
    ),
    NOT_VALID_RETRY_OR_QUIT_INPUT_ERROR(
            String.format("게임을 다시 시도하려면 %s, 종료하려면 %s를 입력해주세요.",
                    BridgeGame.getRetryCommand(),
                    BridgeGame.getQuitCommand())
    );

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return ERROR + message;
    }

}
