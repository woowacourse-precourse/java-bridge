package bridge.bridgeRouter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.bridgeRouter.exception.NotFoundBridgeException;
import bridge.common.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    public void errorTest() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        assertThatThrownBy(
                () -> new BridgeMaker(new TestNumberGenerator(numbers)).makeBridge(numbers.size()))
                .isInstanceOf(NotFoundBridgeException.class)
                .hasMessage(ErrorMessage.NOT_FOUND_BRIDGE.getTagMessage());
    }

    @Test
    public void runTest() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 1, 0));
        List<String> expect = new BridgeMaker(new TestNumberGenerator(numbers)).makeBridge(numbers.size());
        List<String> result = Arrays.asList("U", "U", "D");
        assertThat(expect).isEqualTo(result);
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