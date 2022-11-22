package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest extends NsTest {
    @Test
    void check_move() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.move("U")).isTrue();
    }
    @Test
    void check_wrong_move() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.move("D")).isFalse();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
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
