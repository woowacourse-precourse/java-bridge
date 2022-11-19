package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Moving.UP;
import static bridge.Result.UP_FAIL;
import static bridge.Result.UP_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    @Test
    void 이동_성공_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Result result = bridgeGame.move(0, "U");
        assertThat(result).isEqualTo(UP_SUCCESS);
    }

    @Test
    void 이동_실패_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Result result = bridgeGame.move(0, "D");
        assertThat(result).isEqualTo(UP_FAIL);
    }

    @Test
    void 잘못된_길_접근_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Result result = bridgeGame.move(0, "D");
        assertThat(bridgeGame.isWrongApproach(result)).isEqualTo(true);
    }
}
