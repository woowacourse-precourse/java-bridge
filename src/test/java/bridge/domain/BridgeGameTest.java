package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void generateBridge() {
        BridgeNumberGenerator numberGenerator = new RecordTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        this.bridgeGame = new BridgeGame(new Bridge(bridge));
    }

    @Test
    @DisplayName("retry시 사용자 이동 경로 초기화")
    void retryTest() {
        bridgeGame.retry();
        Assertions.assertThat(bridgeGame.getUsersRoute().getRoute().isEmpty()).isEqualTo(true);
    }

    @Test
    @DisplayName("두 번째에서 실패시 isFail 테스트")
    void isFailTest() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.isFail()).isEqualTo(true);
    }

    @Test
    @DisplayName("사용자의 이동경로 길이가 다리의 길이와 같은지 테스트")
    void isSameLengthTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        Assertions.assertThat(bridgeGame.isSameLength()).isEqualTo(true);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
