package bridge.exception;

import static bridge.constant.BridgeConstant.CLOSE_GAME;
import static bridge.constant.BridgeConstant.LOWER_BLOCK;
import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;
import static bridge.constant.BridgeConstant.RESTART_GAME;
import static bridge.constant.BridgeConstant.UPPER_BLOCK;
import static java.text.MessageFormat.format;

import java.util.Arrays;
import java.util.function.Predicate;

public class Validator {

    public void validateBridgeSize(int size) {
        if (size > MAX_SIZE || size < MIN_SIZE) {
            throw new IllegalArgumentException(format("다리 길이는 {0} 이상, {1} 이하여야 합니다. " + "입력값 : {2}",
                    MIN_SIZE, MAX_SIZE, size));
        }
    }

    public void validateMoveMessage(String message) {
        validateInputIsCorrectValues(message, UPPER_BLOCK, LOWER_BLOCK);
    }

    public void validateGameRestartMessage(String message) {
        validateInputIsCorrectValues(message, RESTART_GAME, CLOSE_GAME);
    }

    private void validateInputIsCorrectValues(String inputMessage,
                                              String... correctValues) {
        if (hasNotCorrectValues(inputMessage, correctValues)) {
            throw new IllegalArgumentException(format("{0} 이외의 값은 허용되지 않습니다. 입력값 : {1}",
                    String.join(",", correctValues), inputMessage));
        }
    }

    private boolean hasNotCorrectValues(String inputMessage, String[] correctValues) {
        return Arrays.stream(correctValues)
                .noneMatch(Predicate.isEqual(inputMessage));
    }
}
