package bridge.domain.errorenum;

import bridge.domain.bridgeenum.BridgeCondition;

public enum ErrorMessage {
    HEAD("[ERROR] "),
    NOT_NUMBER("다리 길이는 자연수만 입력할 수 있습니다."),
    NOT_IN_RANGE(String.format("다리 길이는 %d이상 %d 이하 여야 합니다.", BridgeCondition.MIN.getValue(), BridgeCondition.MAX.getValue()));

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String printMessage() {
        return HEAD.value + value;
    }
}
