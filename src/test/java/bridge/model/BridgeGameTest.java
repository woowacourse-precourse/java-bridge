package bridge.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private List<String> bridge = List.of("U", "D", "D");

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void oneStepMoveCorrectBridge() {
        boolean result = bridgeGame.move(bridge, "U");
        assertThat(result).isTrue();
    }

    @Test
    void MoveCorrectBridge() {
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "D");
        boolean result = bridgeGame.move(bridge, "D");
        assertThat(result).isTrue();
    }

    @Test
    void oneStepMoveInCorrectBridge() {
        boolean result = bridgeGame.move(bridge, "D");
        assertThat(result).isFalse();
    }

    @Test
    void twoStepMoveInCorrectBridge() {
        bridgeGame.move(bridge, "U");
        boolean result = bridgeGame.move(bridge, "U");
        assertThat(result).isFalse();
    }

    @Test
    void choiceRetry() {
        boolean result = bridgeGame.retry("R");
        assertThat(result).isTrue();
    }

    @Test
    void choiceEndGame() {
        boolean result = bridgeGame.retry("Q");
        assertThat(result).isFalse();
    }
}