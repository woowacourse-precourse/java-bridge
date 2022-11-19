package bridge;

import bridge.model.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));
        boolean test = bridgeGame.move("U");

        assertThat(test).isEqualTo(true);
    }
    @Test
    void moveTest2() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D"));
        boolean test = bridgeGame.move("U");

        assertThat(test).isEqualTo(false);
    }

    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D,U,U,D"));
        bridgeGame.retry();
        bridgeGame.retry();
        assertThat(bridgeGame.retry()).isEqualTo(4);
    }
}
