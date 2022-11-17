package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private static final BridgeGame bridgeGame = new BridgeGame();
    private List<String> bridge;

    @BeforeEach
    void createBridge() {
        BridgeNumberGenerator numberGenerator = new BridgeGameTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(3);
    }

    @DisplayName("올바른 다리를 건넌 경우 그 위치에 O 가 표시된 문자열 반환")
    @Test
    void moveCorrectBridge() {
        assertThat(bridgeGame.move("U")).isTrue();
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
