package bridge.utils;

import bridge.controller.BridgeGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @ParameterizedTest(name="size 입력 시 3-20 사이의 숫자가 아니면 예외 처리")
    @ValueSource(strings={"33", "abc", "ㅇㅇㅇ", "0"})
    void bridgeSizeExceptionTest(String size) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isBridgeSizeNumeric(size);
        });
    }
    @ParameterizedTest(name="재시작 여부 입력 시 R이나 Q가 아니면 예외 처리")
    @ValueSource(strings={"ABC", "136", "ㅇㅇ"})
    void retryExceptionTest(String retry) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isRetryValid(retry);
        });
    }
}