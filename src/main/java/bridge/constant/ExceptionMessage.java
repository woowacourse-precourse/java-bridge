package bridge.constant;

import java.util.Arrays;
import java.util.stream.Stream;

public enum ExceptionMessage {
    INVALID_BRIDGE_SIZE_TYPE("[ERROR] 다리의 길이는 숫자의 형태로 주어져야 합니다."),
    INVALID_BRIDGE_SIZE_RANGE(String.format("[ERROR] 다리의 길이는 %d와 %d 사이여야 합니다.",
            Constant.BRIDGE_MIN_SIZE.getValue(),
            Constant.BRIDGE_MAX_SIZE.getValue())),
    INVALID_MOVING(String.format("[ERROR] MOVING은 %s만 가능합니다.",
            Arrays.toString(Stream.of(Moving.values()).map(Enum::toString).toArray()))),
    INVALID_GAME_COMMAND(String.format("[ERROR] GAME_COMMAND는 %s만 가능합니다.",
            Arrays.toString(Stream.of(GameCommand.values()).map(Enum::toString).toArray())));

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}