package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("다리 크기 정상 입력 테스트")
    @ValueSource(strings = {"3", "5", "19", "20"})
    @ParameterizedTest
    void checkValidBridgeSizeTest(String input) {
        assertDoesNotThrow(() -> validator.checkValidBridgeSize(input));
    }

    @DisplayName("다리 크기가 숫자가 아닌 형식으로 올 경우 예외 테스트")
    @ValueSource(strings = {"a", "b", ",", "P", "-"})
    @ParameterizedTest
    void checkInvalidFormatBridgeSizeTest(String input) {
        assertThatThrownBy(() -> validator.checkValidBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_FORMAT.getMessage());
    }

    @DisplayName("다리 크기가 범위에서 벗어난 수로 올 경우 예외 테스트")
    @ValueSource(strings = {"1", "0", "2", "21", "1004"})
    @ParameterizedTest
    void checkInvalidRangeBridgeSizeTest(String input) {
        assertThatThrownBy(() -> validator.checkValidBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RANGE.getMessage());
    }

    @DisplayName("다음 이동 정상 입력 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void checkValidMoveInput(String input) {
        assertDoesNotThrow(() -> validator.checkValidMoveInput(input));
    }

    @DisplayName("다음 이동 입력이 'U'나 'D'가 아닐 경우 예외 테스트")
    @ValueSource(strings = {"P", "1", "d", ","})
    @ParameterizedTest
    void checkInValidMoveInput(String input) {
        assertThatThrownBy(() -> validator.checkValidMoveInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_MOVE_INPUT.getMessage());
    }

    @DisplayName("게임 재시작 정상 입력 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void checkValidRetryInput(String input) {
        assertDoesNotThrow(() -> validator.checkValidRetryInput(input));
    }

    @DisplayName("게임 재시작 입력이 'R'이나 'Q'가 아닐 경우 예외 테스트")
    @ValueSource(strings = {"P", "9", "q", "."})
    @ParameterizedTest
    void checkInvalidRetryInput(String input) {
        assertThatThrownBy(() -> validator.checkValidRetryInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RETRY_INPUT.getMessage());
    }
}