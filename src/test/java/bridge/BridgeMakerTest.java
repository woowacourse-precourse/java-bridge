package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    @Test
    void 다리_타일_만들기() {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
        String bridgeState = bridgeMaker.makeTile(testNumberGenerator.generate());
        assertThat(bridgeState).isEqualTo("U");
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
