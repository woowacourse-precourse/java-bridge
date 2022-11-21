package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @Test
    @DisplayName("다리의 길이가 size만큼 생성되는지 확인하는 테스트")
    void 다리_길이_테스트() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        for (int i = 3; i < 20; i++) {
            List<String> bridge = bridgeMaker.makeBridge(i);
            Assertions.assertThat(bridge.size()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("다리는 숫자에 따라 U 또는 D로 표기되어야 한다.")
    void 다리_생성_테스트() {
        bridgeMaker = new BridgeMaker(new TestNumberGenerator(Lists.newArrayList(0, 0, 1, 1, 0, 1, 0)));
        List<String> bridge = bridgeMaker.makeBridge(7);
        Assertions.assertThat(bridge).containsExactly("D", "D", "U", "U", "D", "U", "D");
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