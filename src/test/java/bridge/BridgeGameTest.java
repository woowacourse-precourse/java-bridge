package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    @Test
    void moveTest() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getPlayer()).isEqualTo(List.of("U", "D"));
    }

    @Test
    void retryTest() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry();
        assertThat(bridgeGame.getPlayer()).isEqualTo(List.of());
    }
}