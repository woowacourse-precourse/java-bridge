package bridge;

import bridge.generator.BridgeNumberGenerator;
import bridge.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 하단이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0))).makeBridge(3));
        assertThat(bridgeGame.move("D")).isEqualTo("[   ]\n[ O ]\n");
    }

    @Test
    void 상단이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0))).makeBridge(3));
        assertThat(bridgeGame.move("U")).isEqualTo("[ O ]\n[   ]\n");
    }

    @Test
    void 하단이동_테스트_실패() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0))).makeBridge(3));
        assertThat(bridgeGame.move("D")).isEqualTo("[   ]\n[ X ]\n");
    }

    @Test
    void 상단이동_테스트_실패() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0))).makeBridge(3));
        assertThat(bridgeGame.move("U")).isEqualTo("[ X ]\n[   ]\n");
    }

    @Test
    void 잘못된_입력() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0))).makeBridge(3));
        assertThatThrownBy(()->bridgeGame.move("T")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void retry() {
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