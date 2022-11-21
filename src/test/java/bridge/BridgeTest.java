package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {

    @Test
    void 이동_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        List<String> user = bridgeGame.move("U");
        assertThat(user).contains("U");

        user = bridgeGame.move("U");
        assertThat(user).contains("UX");

        user = bridgeGame.move("D");
        assertThat(user).contains("D");
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
