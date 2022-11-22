package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void makeBridge_올바른_길이_List_반환() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(5).size()).isEqualTo(5);
    }

    @Test
    void makeBridge_올바른_원소_U또는_D만_포함() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(100))
                .containsOnly("U", "D")
                .doesNotContain("E");
    }

    @Test
    void makeBridge_올바른_값_반환() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1,0,0,1,0,1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThat(bridgeMaker.makeBridge(6))
                .isEqualTo(newArrayList("U", "D", "D", "U", "D", "U"));
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {
        private final List<Integer> numbers;
        private int index = -1;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            index++;
            return numbers.get(index);
        }
    }
}