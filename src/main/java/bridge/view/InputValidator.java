package bridge.view;

import java.util.List;

public class InputValidator {

    private static final int VALID_BRIDGE_SIZE_LOWER_BOUND = 3;
    private static final int VALID_BRIDGE_SIZE_UPPER_BOUND = 20;
    private static final List<String> VALID_MOVING = List.of("U", "D");
    private static final List<String> VALID_COMMAND = List.of("R", "Q");
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_BRIDGE_RANGE_MESSAGE = "다리의 길이는 3에서 20 사이의 값이어야 합니다.";
    private static final String INVALID_MOVING_MESSAGE = "이동 방향은 위: U, 아래: D 중 하나여야 합니다.";
    private static final String INVALID_COMMAND_MESSAGE = "재시도 입력은 재시도: R, 종료: Q 중 하나여야 합니다.";

    public void validateBridgeSize(String inputSize) {
        Integer size = toInteger(inputSize);
        validateBridgeSizeRange(size);
    }

    private Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateBridgeSizeRange(Integer size) {
        if (size < VALID_BRIDGE_SIZE_LOWER_BOUND || VALID_BRIDGE_SIZE_UPPER_BOUND < size) {
            throw new IllegalArgumentException(INVALID_BRIDGE_RANGE_MESSAGE);
        }
    }

    public void validateMoving(String move) {
        if (!VALID_MOVING.contains(move)) {
            throw new IllegalArgumentException(INVALID_MOVING_MESSAGE);
        }
    }

    public void validateCommand(String command) {
        if (!VALID_COMMAND.contains(command)) {
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }
}
