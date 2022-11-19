package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
