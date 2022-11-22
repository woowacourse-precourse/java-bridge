package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.Bridge;
import bridge.model.BridgeResult;
import bridge.model.Retry;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void Retry_여부() {
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }

    @Test
    void 이동가능여부_true() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        BridgeGame bridgeGame = new BridgeGame(bridge, new BridgeResult(List.of(true)), new Retry());
        assertThat(bridgeGame.canMove()).isEqualTo(true);

        bridgeGame = new BridgeGame(bridge, new BridgeResult(List.of(true, true)), new Retry());
        assertThat(bridgeGame.canMove()).isEqualTo(true);
    }

    @Test
    void 이동가능여부_false() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        BridgeGame bridgeGame = new BridgeGame(bridge, new BridgeResult(List.of(false)), new Retry());
        assertThat(bridgeGame.canMove()).isEqualTo(false);

        bridgeGame = new BridgeGame(bridge, new BridgeResult(List.of(true, false)), new Retry());
        assertThat(bridgeGame.canMove()).isEqualTo(false);

        bridgeGame = new BridgeGame(bridge, new BridgeResult(List.of(true, true, false)), new Retry());
        assertThat(bridgeGame.canMove()).isEqualTo(false);

        bridgeGame = new BridgeGame(bridge, new BridgeResult(List.of(true, true, true)), new Retry());
        assertThat(bridgeGame.canMove()).isEqualTo(false);
    }
}
