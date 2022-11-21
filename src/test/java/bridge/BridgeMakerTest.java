package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {
    BridgeMaker maker;

    @BeforeEach
    void setUp() {
        maker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 1, 1, 1, 2)));
    }

    @Test
    void generatingUnexpectedNumbersTest() {
        assertThatThrownBy(() -> {
            maker.makeBridge(5);
        }).isInstanceOf(IllegalStateException.class).hasMessageStartingWith("[ERROR]");
    }

    @Test
    void functionTest() {
        List<String> result = maker.makeBridge(3);

        assertThat(List.of("U", "U", "U")).isEqualTo(result);
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