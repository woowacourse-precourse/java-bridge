package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    @Test
    void 다리_이동_테스트1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move("U");
        assertThat(bridgeGame.isCorrect).isTrue();
    }

    @Test
    void 다리_이동_테스트2() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move("D");
        assertThat(bridgeGame.isCorrect).isFalse();
    }

}