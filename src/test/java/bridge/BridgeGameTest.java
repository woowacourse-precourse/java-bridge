package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(Arrays.asList("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
    }

    @Test
    void moveTest() {
        assertThat(bridgeGame.getUserMove()).isEqualTo(Arrays.asList("U", "D", "U"));
    }

    @Test
    void isClearTest() {
        assertThat(bridgeGame.isClear()).isTrue();
    }

    @Test
    void retryTest() {
        bridgeGame.retry();
        assertThat(bridgeGame.getUserMove()).isEmpty();
        assertThat(bridgeGame.getTryNumber()).isEqualTo(2);
    }
}
