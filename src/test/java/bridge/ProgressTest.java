package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProgressTest {
    BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 1));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(5);

    BridgeGame bridgeGame = new BridgeGame(bridge);

    @Test
    @DisplayName("입력 받은 수 대로 다리 생성")
    void bridgeMakerTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "U");
    }

    @Test
    @DisplayName("up down 입력 값에 따른 출력 검증")
    void movingProcessTest() {
        boolean up = bridgeGame.move("U");
        boolean down = bridgeGame.move("D");

        assertThat(up).isTrue();
        assertThat(down).isTrue();
        assertThat(bridgeGame.move("S")).isFalse();
    }

    @Test
    @DisplayName("시작 재시작 검증")
    void retryTest() {
        assertThat(bridgeGame.retry("Q")).isFalse();
        assertThat(bridgeGame.retry("R")).isTrue();
    }
}
