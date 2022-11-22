package bridge.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @ParameterizedTest(name="size 입력 시 3-20 사이의 숫자가 아니면 예외 처리")
    @ValueSource(strings={"33", "abc", "ㅇㅇㅇ", "0"})
    void bridgeSizeExceptionTest(String size) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isBridgeSizeNumeric(size);
        });
    }
    @ParameterizedTest(name="사용자의 이동으로 U와 D 이외의 것이 입력되었을 때 예외 처리")
    @ValueSource(strings={"40", "ㅁ", "A"})
    void movementExceptionTest(String movement) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isMovementValid(movement);
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