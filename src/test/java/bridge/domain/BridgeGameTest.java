package bridge.domain;

import bridge.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 다리_상태_테스트1() {
        bridgeGame.move("U", true);
        Assertions.assertThat(bridgeGame.getFirstRoad().toString()).isEqualTo("O");
        Assertions.assertThat(bridgeGame.getSecondRoad().toString()).isEqualTo(" ");
    }

    @Test
    void 다리_상태_테스트2() {
        bridgeGame.move("D", false);
        Assertions.assertThat(bridgeGame.getFirstRoad().toString()).isEqualTo(" ");
        Assertions.assertThat(bridgeGame.getSecondRoad().toString()).isEqualTo("X");
    }

    @Test
    void 다리_상태_테스트3() {
        bridgeGame.move("U", true);
        bridgeGame.move("D", true);
        bridgeGame.move("U", false);
        Assertions.assertThat(bridgeGame.getFirstRoad().toString()).isEqualTo("O X");
        Assertions.assertThat(bridgeGame.getSecondRoad().toString()).isEqualTo(" O ");
    }

}