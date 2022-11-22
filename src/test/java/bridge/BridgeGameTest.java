package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 1));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(5);

    public void bridgeMove(BridgeGame bridgeGame) {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
    }

    @Test
    @DisplayName("사용자 입력 기록 테스트")
    void historyTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeMove(bridgeGame);

        List<String> history = List.of("U", "D", "UF", "DF", "DF");

        assertThat(bridgeGame.inputHistory()).isEqualTo(history);
    }

}
