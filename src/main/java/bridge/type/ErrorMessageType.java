package bridge.type;

import static bridge.type.CommonConstantType.MAX_BRIDGE_LENGTH;
import static bridge.type.CommonConstantType.MIN_BRIDGE_LENGTH;

public enum ErrorMessageType {

    INVALID_INTEGER("숫자를 입력해야 합니다."),
    INVALID_BRIDGE_LENGTH("다리 길이는 %d ~ %d 사이의 값이어야 합니다.",
            MIN_BRIDGE_LENGTH, MAX_BRIDGE_LENGTH),
    ;

    private final String message;

    ErrorMessageType(String message, Object... replacers) {
        this.message = String.format(message, replacers);
    }

    @Override
    public String toString() {
        return message;
    }
}
