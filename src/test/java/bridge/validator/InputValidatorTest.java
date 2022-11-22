package bridge.validator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static bridge.exception.Exception.*;
import static bridge.validator.InputValidator.*;

public class InputValidatorTest {
    @DisplayName("다리 길이를 입력받을 때 숫자가 아니라면 예외 처리")
    @ValueSource(strings = {"asd", "우테코", "11.2312", "!@#$~!@"})
    @ParameterizedTest
    void inputBridgeSizeByNonNumeric(String bridgeSize) {
        assertThatThrownBy(() -> validateFormat(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER.getMessage());
    }

    @DisplayName("다리 길이를 입력받을 때 3에서 20 사이가 아니면 예외 처리")
    @ValueSource(ints = {0, 123, -3, 2, 25})
    @ParameterizedTest
    void inputBridgeSizeOutOfRange(int bridgeSize) {
        assertThatThrownBy(() -> validateRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE.getMessage());
    }

    @DisplayName("이동 방향을 입력받을 때 U 또는 D가 아니면 예외 처리")
    @ValueSource(strings = {"w", "112", "UP", "d"})
    @ParameterizedTest
    void inputInvalidDirection(String direction) {
        assertThatThrownBy(() -> validateDirection(direction))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DIRECTION.getMessage());
    }
}
