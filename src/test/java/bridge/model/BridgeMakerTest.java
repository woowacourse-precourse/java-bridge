package bridge.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertRandomNumberInRangeTest(() -> {
            assertThat(bridgeMaker.makeBridge(3)).isEqualTo(List.of("U", "U", "U"));
        }, 1, 1, 1);
    }

    @Test
    void 다리_생성_예외_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(
                newArrayList(3, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(3)).isInstanceOf(
                IllegalArgumentException.class);
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
