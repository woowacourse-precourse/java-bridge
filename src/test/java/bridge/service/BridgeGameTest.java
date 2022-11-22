package bridge.service;

import bridge.bo.Bridge;
import bridge.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(3));
        this.bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U","U");
    }

    @Test
    void move() {
        boolean realResult = bridgeGame.move("U","D");
        assertThat(realResult).isFalse().as("MoveFailed");
        assertThat(bridgeGame.getUserMoves().get(1)).isEqualTo("U").as("moveSaved");
        assertThat(bridgeGame.getResults().get(1)).isFalse().as("resultSaved");
    }

    @Test
    void retry() {
        int expectedSize = 0;
        bridgeGame.retry();
        int realUserMovesSize = bridgeGame.getUserMoves().size();
        int realResultsSize = bridgeGame.getResults().size();
        int realTries = bridgeGame.getTries();
        assertThat(realUserMovesSize).as("userMovesClear").isEqualTo(expectedSize);
        assertThat(realResultsSize).as("resultsClear").isEqualTo(expectedSize);
        assertThat(realTries).as("triesNumberPlus").isEqualTo(2);
    }

    @Test
    void finish() {
        bridgeGame.finish();
        assertThat(bridgeGame.getBridgeIterator().hasNext()).isFalse();
    }
}