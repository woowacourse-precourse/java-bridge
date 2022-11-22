package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    void 입력값에따라_다리를_생성하는지_테스트() {
        //given
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 0, 1));
        BridgeMaker maker = new BridgeMaker(generator);

        //when
        List<String> bridge = maker.makeBridge(4);

        //then
        assertThat(bridge).containsExactly("U", "D", "D", "U");
    }

    static class TestBridgeNumberGenerator implements BridgeNumberGenerator {
        private List<Integer> numbers;

        TestBridgeNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
