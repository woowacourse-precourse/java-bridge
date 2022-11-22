package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;

class BridgeMakerTest {

    @Test
    void 생성된_임의의_0_또는_1값을_D_또는_U값으로_변환한_다리를_생성한다(){
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "U");
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