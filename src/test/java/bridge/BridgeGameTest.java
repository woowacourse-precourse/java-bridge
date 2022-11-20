package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {

    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> topBridge = new ArrayList<>();
        List<String> bottomBridge = new ArrayList<>();
        bridgeGame.move(topBridge, bottomBridge, "U");

        assertThat(List.of("O")).isEqualTo(topBridge);
        assertThat(List.of(" ")).isEqualTo(bottomBridge);
    }

    @Test
    void failureTest() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> topBridge = new ArrayList<>();
        List<String> bottomBridge = new ArrayList<>();
        bridgeGame.failure(topBridge, bottomBridge, "U");

        assertThat(List.of("X")).isEqualTo(topBridge);
        assertThat(List.of(" ")).isEqualTo(bottomBridge);
    }

    @Test
    void retryTest() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(true).isEqualTo(bridgeGame.retry("R"));
    }

    @Test
    void rightMoveTest() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(true).isEqualTo(bridgeGame.rightMove("U", "U"));
    }
}
