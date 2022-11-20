package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @DisplayName("이동하려는 칸이 'U'나 'D'가 아닐 경우 예외 처리한다. (Case 1)")
    @Test
    void invalidMoveCase1() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(() -> bridgeGame.move("X"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하려는 칸이 'U'나 'D'가 아닐 경우 예외 처리한다. (Case 2)")
    @Test
    void invalidMoveCase2() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(() -> bridgeGame.move("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하려는 칸이 'U'나 'D'가 아닐 경우 예외 처리한다. (Case 3)")
    @Test
    void invalidMoveCase3() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        assertThatThrownBy(() -> bridgeGame.move("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
