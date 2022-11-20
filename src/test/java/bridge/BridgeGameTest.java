package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.DIRECTION.DOWN;
import static bridge.DIRECTION.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    @DisplayName("이동할 칸은 U, D 만 입력해야 한다.")
    void moveExceptionTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThrows(IllegalArgumentException.class,
                () -> bridgeGame.move("app"));
        assertThrows(IllegalArgumentException.class,
                () -> bridgeGame.move("u"));
    }

    @Test
    @DisplayName("성공하는 경우")
    void moveSuccessTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.isComplete()).isFalse();
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.isComplete()).isFalse();
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.isComplete()).isTrue();
    }

    @Test
    @DisplayName("실패하는 경우")
    void moveFailTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.isComplete()).isFalse();
        assertThat(bridgeGame.move("U")).isFalse();
        assertThat(bridgeGame.isComplete()).isFalse();
    }

    @Test
    @DisplayName("2번 재시도")
    void retryTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry();

        assertThat(bridgeGame.getGuess()).isEqualTo(null);
        assertThat(bridgeGame.getBridge()).containsExactly(UP, DOWN, DOWN);
        assertThat(bridgeGame.getCurrentIdx()).isEqualTo(0);
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.retry();

        assertThat(bridgeGame.getGuess()).isEqualTo(null);
        assertThat(bridgeGame.getBridge()).containsExactly(UP, DOWN, DOWN);
        assertThat(bridgeGame.getCurrentIdx()).isEqualTo(0);
        assertThat(bridgeGame.getTryCount()).isEqualTo(3);




    }
}
