package bridge.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {
    private final String SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String MOVE_ERROR = "[ERROR] U 또는 D로 입력해야 합니다.";
    private final String RESTART_ERROR = "[ERROR] R 또는 Q를 입력하셔야 합니다.";

    @Test
    @DisplayName("다리_길이_검사")
    void bridge_length_validation() {
        assertThatThrownBy(() -> Validation.bridgeLengthValidation(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SIZE_ERROR);
    }

    @Test
    @DisplayName("움직인_위치_검사")
    void moving_validation() {
        assertThatThrownBy(() -> Validation.movedValidation("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MOVE_ERROR);
    }

    @Test
    @DisplayName("재시작_입력값_검사")
    void restart_check_validation() {
        assertThatThrownBy(() -> Validation.restartValidation("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RESTART_ERROR);
    }

}