package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void generateBridge() {
        BridgeNumberGenerator numberGenerator = new RecordTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        this.bridge = new Bridge(bridge);
    }

    @Test
    @DisplayName("두 번째 자리 D")
    void matchesTest() {
        Assertions.assertThat(this.bridge.matches(1, "D")).isEqualTo(true);
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
