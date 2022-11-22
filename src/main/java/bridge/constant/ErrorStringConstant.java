package bridge.constant;

public enum ErrorStringConstant {
    BRIDGE_LENGTH_INPUT_ERROR_MESSAGE(
            "[ERROR] 다리의 길이는 " + BridgeLengthConstant.BRIDGE_LENGTH.getBridgeLengthStartsFrom() + " 부터 "
                    + BridgeLengthConstant.BRIDGE_LENGTH.getBridgeLengthEndsWith() + " 까지 입니다."),
    UP_OR_DOWN_INPUT_ERROR_MESSAGE(
            "[ERROR] 다리는 " + UpDownConstant.UP.getSymbol() + "혹은 " + UpDownConstant.DOWN.getSymbol() + "만 입력가능합니다."),
    RETRY_OR_EXIT_INPUT_ERROR_MESSAGE(
            "[ERROR] 게임 진행 여부는 " + RetryExitConstant.RETRY.getSymbol() + "혹은 " + RetryExitConstant.EXIT.getSymbol()
                    + "만 입력가능합니다."),;

    private final String error;

    ErrorStringConstant(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
