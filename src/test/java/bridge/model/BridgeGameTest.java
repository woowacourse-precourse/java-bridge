package bridge.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void oneStepMoveCorrectBridge() {
        boolean result = bridgeGame.move("U", "U");
        assertThat(result).isTrue();
    }

    @Test
    void MoveCorrectBridge() {
        bridgeGame.move("U", "U");
        bridgeGame.move("D", "D");
        boolean result = bridgeGame.move("D", "D");
        assertThat(result).isTrue();
    }

    @Test
    void oneStepMoveInCorrectBridge() {
        boolean result = bridgeGame.move("U", "D");
        assertThat(result).isFalse();
    }

    @Test
    void twoStepMoveInCorrectBridge() {
        bridgeGame.move("U", "U");
        boolean result = bridgeGame.move("D", "U");
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