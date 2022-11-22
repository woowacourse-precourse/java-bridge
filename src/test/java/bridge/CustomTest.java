package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.Test;

class CustomTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_제한사이즈_초과_예외_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(22, 24));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThatThrownBy(()->bridgeMaker.makeBridge(22)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_생성_제한사이즈_미만_예외_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(22, 24));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThatThrownBy(()->bridgeMaker.makeBridge(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_이동_예외_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        assertThatThrownBy(()-> bridgeGame.move("Z")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_종료_예외_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move("D");
        assertThatThrownBy(()-> bridgeGame.retry("B")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_이동_맞췄을시_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move("U");
        assertThat(bridgeGame.step).isEqualTo(1);
        assertThat(bridgeGame.result).isEqualTo(true);
    }

    @Test
    void 다리_이동_틀렸을시_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move("D");
        assertThat(bridgeGame.step).isEqualTo(1);
        assertThat(bridgeGame.result).isEqualTo(false);
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
