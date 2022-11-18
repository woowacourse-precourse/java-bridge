package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
    @DisplayName("최대길이 다리 생성 테스트, 최소길이는 application 에서 테스트함")
    @Test
    void createBridgeMaker() {
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(
                newArrayList(1, 1, 0, 1, 1, 0, 1, 1, 0, 1
                        , 1, 0, 1, 1, 0, 1, 1, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsExactly("U", "U", "D", "U", "U", "D", "U", "U", "D", "U"
                , "U", "D", "U", "U", "D", "U", "U", "D", "U", "U");
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
