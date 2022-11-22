package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("이동할 칸이 U, D가 아닌 다른 문자일 경우 예외가 발생한다.")
    @Test
    void moveInvalidPosition() {
        assertThatThrownBy(() -> new BridgeGame(new BridgeStatus(Arrays.asList("U", "D", "D"))).move("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 U, D로 시작하지만 더 긴 문자열일 경우 예외가 발생한다")
    @Test
    void moveTooLongPosition() {
        assertThatThrownBy(() -> new BridgeGame(new BridgeStatus(Arrays.asList("U", "D", "D"))).move("UDD"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 빈 문자열일 경우 예외가 발생한다")
    @Test
    void moveEmptyPosition() {
        assertThatThrownBy(() -> new BridgeGame(new BridgeStatus(Arrays.asList("U", "D", "D"))).move(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
