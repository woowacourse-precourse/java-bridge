package bridge.constant;

import bridge.view.constant.RetryOptions;

public enum ErrorMessage {
    EMPTY_VALUE("값을 입력하지 않았습니다."),
    NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_BRIDGE_LENGTH("다리 길이는 " + BridgeProperties.MIN_LENGTH.get() + "부터 "
            + BridgeProperties.MAX_LENGTH.get() +" 사이의 숫자여야 합니다."),
    INVALID_PANEL(Directions.UP.getSymbol() + "(위), " + Directions.DOWN.getSymbol() +
            "(아래) 중 하나만 입력해주세요."),
    INVALID_RETRY_OPTION(RetryOptions.RETRY.get() + "(재시작), " + RetryOptions.QUIT.get() +
            "(종료) 중 하나만 입력해주세요."),
    INVALID_DIRECTION_DIGIT_ARGUMENT("방향으로 적절하지 않은 숫자가 확인되었습니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return ERROR_PREFIX + errorMessage;
    }
}
