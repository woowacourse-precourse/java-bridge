package bridge.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void move_현재_인덱스_반환_확인() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        assertThat(bridgeGame.getCurrentIndex()).isEqualTo(1);
    }

    @Test
    void retry_현재_인덱스_및_시도_횟수_반환_확인() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 6);

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.retry();
        bridgeGame.retry();

        // then
        assertThat(bridgeGame.getCurrentIndex()).isEqualTo(-1);
        assertThat(bridgeGame.getTrialCount()).isEqualTo(3);
    }
}