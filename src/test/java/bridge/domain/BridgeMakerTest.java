package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("다리가 정상적으로 생성되는지 확인")
    @Test
    void createBridgeSuccess() {
        assertThat(bridgeMaker.makeBridge(3)).containsExactly("U", "D", "D");
    }

    @DisplayName("다리 길이가 정상적인지 확인")
    @Test
    void checkBridgeSize() {
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
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
