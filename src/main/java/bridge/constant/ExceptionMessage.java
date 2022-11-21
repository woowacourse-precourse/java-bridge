package bridge.constant;

import java.util.Arrays;
import java.util.stream.Stream;

public enum ExceptionMessage {
    INVALID_BRIDGE_SIZE_TYPE("다리의 길이는 정수의 형태로 주어져야 합니다."),
    INVALID_BRIDGE_SIZE_RANGE(String.format("다리의 길이는 %d와 %d 사이여야 합니다.",
            Constant.BRIDGE_MIN_SIZE.getValue(),
            Constant.BRIDGE_MAX_SIZE.getValue())),
    INVALID_MOVING(String.format("이동할 칸은 %s중 하나만 가능합니다.",
            Arrays.toString(Stream.of(Moving.values()).map(Enum::toString).toArray()))),
    INVALID_GAME_COMMAND(String.format("재시도 여부는 %s중 하나만 가능합니다.",
            Arrays.toString(Stream.of(GameCommand.values()).map(Enum::toString).toArray())));

    private final String message;
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = ERROR_MESSAGE_HEADER + message;
    }

    public String getString() {
        return message;
    }
}