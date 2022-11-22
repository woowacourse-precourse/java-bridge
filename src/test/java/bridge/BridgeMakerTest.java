package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("랜덤 값에 따라 0은 D로, 1은 U로 바꾸어 다리를 생성한다.")
    @Test
    void createCorrectBridge() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).containsExactly("D", "D", "D", "D");
    }

    @DisplayName("다리의 길이는 입력값과 같다.")
    @Test
    void checkBridgeSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).hasSize(4);
    }

    @DisplayName("다리는 위 칸을 나타내는 U와 아래 칸을 나타내는 D로만 이루어져 있다.")
    @Test
    void checkBridgeContents() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(10);
        assertThat(bridge).containsOnly("D", "U");
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