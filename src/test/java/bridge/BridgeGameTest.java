package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    @Test
    void 이동_성공_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isSuccess = bridgeGame.move(0, "U");
        assertThat(isSuccess).isEqualTo(true);
    }

    @Test
    void 이동_실패_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isSuccess = bridgeGame.move(0, "D");
        assertThat(isSuccess).isEqualTo(false);
    }

    @Test
    void 총_시도_횟수_증가_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }

    @Test
    void 현재_게임_결과_초기화_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(0, "D");
        bridgeGame.move(1, "D");
        bridgeGame.retry();
        assertThat(bridgeGame.getResults().size()).isEqualTo(0);
    }
}
