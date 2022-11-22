package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @DisplayName("다리 길이에 대한 입력값을 검증")
    @ValueSource(strings = {"", " ", "2", "21", "s", "1w"})
    @ParameterizedTest
    void validateBridgeSizeTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateBridgeSize(input);
        });
    }

    @DisplayName("유저의 움직임에 대한 입력값을 검증")
    @ValueSource(strings = {"", " ", "d", "DD", "UD", "UP", "1"})
    @ParameterizedTest
    void validateUserMovingTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateMove(input);
        });
    }

    @DisplayName("재시도 여부에 대한 입력값을 검증")
    @ValueSource(strings = {"", " ", "q", "r", "QQ", "Q ", "1"})
    @ParameterizedTest
    void validateGameCommandTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateGameCommand(input);
        });
    }
}