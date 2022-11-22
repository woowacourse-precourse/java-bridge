package bridge.bridgeGame;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.bridge.BridgeNumberGenerator;
import bridge.bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    @Test
    public void makeBridgeTest() throws Exception {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGame bridgeGame = new BridgeGame(bridgeNumberGenerator);

        // when
        bridgeGame.makeBridge(5);

        // then
        assertThat(bridgeGame.getBridgeGameState().bridgeSize()).isEqualTo(5);
    }
}