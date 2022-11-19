package bridge.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("다리게임 생성 시 예외")
    void makeBridgeGame() {
        assertThatThrownBy(() -> new BridgeGame(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("진행되지 않은 다리 게임 public 메소드 호출 시 예외")
    void checkResult() {
        BridgeGame game = new BridgeGame();

        assertThatThrownBy(game::recentResult)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::end)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::movable)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> game.move("test", 0))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> game.retry("R"))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> game.isNotBridgeLength(0))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::printPlayCount)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::state)
                .isInstanceOf(IllegalStateException.class);
    }
}
