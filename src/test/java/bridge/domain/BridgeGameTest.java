package bridge.domain;

import bridge.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 다리_상태_테스트() {
        bridgeGame.move("U", true);
        Assertions.assertThat(bridgeGame.getFirstRoad().toString()).isEqualTo("O");
        Assertions.assertThat(bridgeGame.getSecondRoad().toString()).isEqualTo(" ");
    }

}