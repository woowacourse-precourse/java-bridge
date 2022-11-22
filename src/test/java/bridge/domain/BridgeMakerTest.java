package bridge.domain;

import bridge.domain.generator.BridgeNumberGenerator;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init(){
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력받은 길이에 해당하는 다리 모양을 보여주는 테스트")
    @Test
    void 입력받은_길이에_해당하는_다리_모양을_보여주는_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U","D","D");
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