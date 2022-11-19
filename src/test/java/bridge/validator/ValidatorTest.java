package bridge.validator;

import bridge.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator = new Validator();

    @Test
    @DisplayName("다리 크기 정상 입력 테스트")
    void checkValidBridgeSizeTest() {
        assertDoesNotThrow(() -> validator.checkValidBridgeSize("10"));
    }

    @Test
    @DisplayName("다리 크기가 숫자가 아닌 형식으로 올 경우 예외 테스트")
    void checkInvalidFormatBridgeSizeTest() {
        assertThatThrownBy(() -> validator.checkValidBridgeSize("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_FORMAT.getMessage());
    }

    @Test
    @DisplayName("다리 크기가 범위에서 벗어난 수로 올 경우 예외 테스트")
    void checkInvalidRangeBridgeSizeTest() {
        assertThatThrownBy(() -> validator.checkValidBridgeSize("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RANGE.getMessage());
    }

    @Test
    @DisplayName("다음 이동 정상 입력 테스트")
    void checkValidMoveInput() {
        assertDoesNotThrow(() -> validator.checkValidMoveInput("U"));
    }

    @Test
    @DisplayName("다음 이동 입력이 'U'나 'D'가 아닐 경우 예외 테스트")
    void checkInValidMoveInput() {
        assertThatThrownBy(() -> validator.checkValidMoveInput("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_MOVE_INPUT.getMessage());
    }

    @Test
    @DisplayName("게임 재시작 정상 입력 테스트")
    void checkValidRetryInput() {
        assertDoesNotThrow(() -> validator.checkValidRetryInput("R"));
    }

    @Test
    @DisplayName("게임 재시작 입력이 'R'이나 'Q'가 아닐 경우 예외 테스트")
    void checkInvalidRetryInput() {
        assertThatThrownBy(() -> validator.checkValidRetryInput("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RETRY_INPUT.getMessage());
    }
}