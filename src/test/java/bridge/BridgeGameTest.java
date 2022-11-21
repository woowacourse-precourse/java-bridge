package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 현재_위치_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.getBridgePosition()).isEqualTo(1);
    }
}