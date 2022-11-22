package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        List<String> bridge = List.of("U", "D", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    void evaluateMove_TrueTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.evaluateMove()).isEqualTo(true);
    }

    @Test
    void evaluateMove_FalseTest() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.evaluateMove()).isEqualTo(false);
    }

    @Test
    void isGameOn_FirstStageTest() {
        assertThat(bridgeGame.isGameOn()).isEqualTo(true);
    }

    @Test
    void isGameOn_FinalStageTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.isGameOn()).isEqualTo(false);
    }

    @Test
    void isGameOn_QuitTest() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("Q");
        assertThat(bridgeGame.isGameOn()).isEqualTo(false);
    }

    @Test
    void retry_RetryTest() {
        bridgeGame.move("U");
        bridgeGame.retry("R");
        int result = bridgeGame.getCurrentProgress();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void retry_QuitTest() {
        bridgeGame.retry("Q");
        assertThat(bridgeGame.getDirectionAt(0)).isEqualTo("Q");
    }
}