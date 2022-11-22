package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이의 값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1q2", "12!", "123 ", "", " "})
    void checkBridgeByNumber(String input) {
        assertThatThrownBy(() -> Exception.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리 길이의 값이 3 ~ 20 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 0, 21, 100})
    void checkBridgeByRange(int input) {
        assertThatThrownBy(() -> Exception.checkBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("플레이어가 이동할 칸의 값이 'U' 또는 'D'가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "DB", "U!", "d", "D ", "", " "})
    void checkMoving(String input) {
        assertThatThrownBy(() -> Exception.checkMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("게임 재시작/종료 여부의 값이 'R' 또는 'Q'가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "DQ", "R!", "q", "Q ", "", " "})
    void checkRetry(String input) {
        assertThatThrownBy(() -> Exception.checkRetry(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}