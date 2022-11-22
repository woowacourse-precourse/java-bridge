package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    void TestMove() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("U", "D", "U");
        String userInput = "U";
        int index = 2;
        boolean move = bridgeGame.move(bridge, userInput, index);
        assertThat(move).isEqualTo(true);
        index = 1;
        boolean move2 = bridgeGame.move(bridge, userInput, index);
        assertThat(move2).isEqualTo(false);
    }

    @Test
    void TestRetry() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean r = bridgeGame.retry("R");
        assertThat(r).isEqualTo(true);
        boolean r2 = bridgeGame.retry("Q");
        assertThat(r2).isEqualTo(false);
    }
}