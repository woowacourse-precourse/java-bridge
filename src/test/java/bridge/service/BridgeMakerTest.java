package bridge.service;

import bridge.Constants.ErrorMessageConstant;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
    @Test
    void 다리_사이즈_테스트() {
        int BRIDGE_SIZE = 5;
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
        assertThat(bridge.size()).isEqualTo(BRIDGE_SIZE);
    }

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_오류_테스트() {
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(newArrayList(1, 2, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(3))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.RANDOM_NUMBER_GENERATOR_OPERATION_FAILED);
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
