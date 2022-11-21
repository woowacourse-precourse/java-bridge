package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.BridgeGame;
import bridge.exception.CannotCrossBridgeException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("[성공] 서로 같은 direction을 비교할 경우 true")
    @Test
    void compareDirectionBySameDirection() {
        List<String> bridge = List.of("U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean result = bridgeGame.compareDirection("U", 0);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("[성공] 서로 다른 direction을 비교할 경우 false")
    @Test
    void compareDirectionByDifferentDirection() {
        List<String> bridge = List.of("U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean result = bridgeGame.compareDirection("D", 0);
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("[예외 발생] 건널 수 없는 칸을 건너려 하면 CannotCrossBridgeException 발생")
    @Test
    void moveByDifferentDirection() {
        List<String> bridge = List.of("U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThatThrownBy(() -> bridgeGame.move("U", 1)).isInstanceOf(
            CannotCrossBridgeException.class);
    }
}
