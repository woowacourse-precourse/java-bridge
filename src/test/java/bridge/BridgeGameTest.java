package bridge;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("[성공] 서로 같은 direction을 비교할 경우 false")
    @Test
    void compareDirectionByDifferentDirection() {
        List<String> bridge = List.of("U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean result = bridgeGame.compareDirection("D", 0);
        assertThat(result).isEqualTo(false);
    }
}
