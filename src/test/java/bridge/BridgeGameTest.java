package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest extends NsTest {
    @Test
    void move_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.isMovable("U")).isTrue();
    }

    @Test
    void wrong_move_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.isMovable("D")).isFalse();
    }

    @Test
    void retry_테스트(){
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(new ArrayList<>(Arrays.asList(1, 1, 1)));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        User user = bridgeGame.getUser();
        bridgeGame.retry();
        assertThat(user).isNotEqualTo(bridgeGame.getUser());
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
