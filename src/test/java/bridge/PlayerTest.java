package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("움직임(move)의 입력 값 예외 처리")
    @Test
    void validateMoving() {
        final Player player = new Player();
        final String input = "u";

        final boolean result = player.validateMoving(input);

        assertThat(result).isFalse();
    }

    @DisplayName("재시도(retry)의 입력 값 예외 처리")
    @Test
    void validateRetry() {
        final Player player = new Player();
        final String input = "r";

        final boolean result = player.validateRetry(input);

        assertThat(result).isFalse();
    }
}