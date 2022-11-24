package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.drawer.BridgeCase;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest extends NsTest {
    @Test
    void 정답_비교_테스트1() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(1, 0, 0))).makeBridge(3), 0);
        assertThat(bridgeGame.isAnswer("U", 0)).isTrue();
    }

    @Test
    void 정답_비교_테스트2() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(0, 0, 0))).makeBridge(3), 0);
        assertThat(bridgeGame.isAnswer("U", 0)).isFalse();
    }

    @Test
    void 일치하는_열거_타입을_찾는_테스트1() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(1, 0, 0))).makeBridge(3), 0);
        assertThat(bridgeGame.move("U", 0).name()).isEqualTo(BridgeCase.FIRST_UP.name());
    }

    @Test
    void 일치하는_열거_타입을_찾는_테스트2() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(1, 1, 0))).makeBridge(3), 0);
        assertThat(bridgeGame.move("D", 2).name()).isEqualTo(BridgeCase.NOT_FIRST_DOWN.name());
    }

    @Test
    void 재시도_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new BridgeRandomNumberGenerator()).makeBridge(3), 0);
        assertThat(bridgeGame.retry("R")).isTrue();
    }

    @Test
    void 종료_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new BridgeRandomNumberGenerator()).makeBridge(3), 0);
        assertThat(bridgeGame.retry("T")).isFalse();
    }

    @Override
    protected void runMain() {
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
