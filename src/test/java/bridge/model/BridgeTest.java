package bridge.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {
    @Test
    void successStepTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        Bridge bridge = new Bridge(3,numberGenerator);
        assertThat(bridge.isSuccess(2,"D")).isTrue();

    }

    @Test
    void playerArrivedFinishPointTest(){
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        Bridge bridge = new Bridge(3,numberGenerator);
        Player player = new Player(1,3);
        assertThat(bridge.isFinish(player)).isEqualTo(true);
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
