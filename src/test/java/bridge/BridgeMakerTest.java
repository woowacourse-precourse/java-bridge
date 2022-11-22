package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    private final int bridgeSize = 5;

    @DisplayName("생성한 다리의 숫자가 0과 1 이외의 값을 가질 경우 예외 발생")
    @Test
    void createBridgeByOtherNumber() {
        assertThatThrownBy(() -> {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 2, 1, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            bridgeMaker.makeBridge(bridgeSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 다리의 사이즈와 동일한 크기의 다리 생성")
    @Test
    void createBridgeByInputSize() {
        assertSimpleTest(() -> {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            assertThat(bridge.size()).isEqualTo(bridgeSize);
        });
    }

    @DisplayName("U와 D로 구성된 다리 생성")
    @Test
    void createBridge() {
        assertSimpleTest(() -> {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            assertThat(bridge).containsExactly("U", "D", "D", "U", "D");
        });
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