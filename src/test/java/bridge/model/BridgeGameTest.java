package bridge.model;

import bridge.model.data.GameResultData;
import bridge.model.data.MapData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    void setUp() {
        bridgeGame.start(3);
    }


    @Test
    void finishTest() {
        GameResultData successResult = bridgeGame.finish(true);
        Assertions.assertThat(successResult).isNotNull();
        Assertions.assertThat(successResult.getMapData()).isInstanceOf(MapData.class);
        Assertions.assertThat(successResult.getTotalTrials()).isEqualTo(1);
        Assertions.assertThat(successResult.getTotalResult()).isEqualTo("성공");

        GameResultData failResult = bridgeGame.finish(false);
        Assertions.assertThat(failResult.getTotalResult()).isEqualTo("실패");
    }

    @Test
    void createMapTest() {
        Assertions.assertThat(bridgeGame.createMap()).isInstanceOf(MapData.class);
    }
}