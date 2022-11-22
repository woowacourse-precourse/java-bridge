package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.combinator.BridgeCase;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest extends NsTest {
    @Test
    void 정답_비교_테스트1() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(1, 0, 0))).makeBridge(3),0);
        assertThat(bridgeGame.isAnswer("U", 0)).isTrue();
    }

    @Test
    void 정답_비교_테스트2() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(0, 0, 0))).makeBridge(3),0);
        assertThat(bridgeGame.isAnswer("U", 0)).isFalse();
    }

    @Test
    void 일치하는_열거_타입을_찾는_테스트1() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(1, 0, 0))).makeBridge(3),0);
        assertThat(bridgeGame.move("U", 0).name()).isEqualTo(BridgeCase.TRUE_ZERO_UP.name());
    }

    @Test
    void 일치하는_열거_타입을_찾는_테스트2() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(
                new TestNumberGenerator(newArrayList(1, 1, 0))).makeBridge(3),0);
        assertThat(bridgeGame.move("U", 2).name()).isEqualTo(BridgeCase.FALSE_POSITIVE_UP.name());
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
