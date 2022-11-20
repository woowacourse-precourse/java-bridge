package bridge;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    public static final int GENERATED_NUMBER = 0;

    @DisplayName("다리 생성 테스트")
    @Test
    void createBridgeTest() {
        BridgeNumberGenerator numberGenerator = new BridgeTestNumberGenerator(Lists.newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);

        assertThat(bridge).containsExactly("D", "U", "U");
    }

    static class BridgeTestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        public BridgeTestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(GENERATED_NUMBER);
        }
    }
}