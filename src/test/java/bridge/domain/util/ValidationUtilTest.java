package bridge.domain.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {
    private final String SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String MOVE_ERROR = "[ERROR] U 또는 D로 입력해야 합니다.";
    private final String RESTART_ERROR = "[ERROR] R 또는 Q를 입력하셔야 합니다.";

    @Test
    @DisplayName("다리_길이_유효성_검사")
    void bridge_size_validation() {
        assertThatThrownBy(() -> ValidationUtil.bridgeSizeValidation(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SIZE_ERROR);
    }

    @Test
    @DisplayName("움직인_위치_입력값_유효성_검사")
    void move_validation() {
        assertThatThrownBy(() -> ValidationUtil.movedValidation("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MOVE_ERROR);
    }

    @Test
    @DisplayName("재시작_커맨드_입력값_유효성_검사")
    void restart_validation() {
        assertThatThrownBy(() -> ValidationUtil.restartValidation("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RESTART_ERROR);
    }

}