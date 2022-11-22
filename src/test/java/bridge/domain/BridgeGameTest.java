package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.utils.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void move_게임_성공_반환값_확인() {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1,0,1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        // then
        assertThat(bridgeGame.getCurrentIndex()).isEqualTo(2);
        assertThat(bridgeGame.isGameContinue()).isEqualTo(true);
        assertThat(bridgeGame.isGameSuccess()).isEqualTo(true);
    }

    @Test
    void move_게임_실패_반환값_확인() {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1,0,1,1,0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 5);

        // when
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        assertThat(bridgeGame.getCurrentIndex()).isEqualTo(3);
        assertThat(bridgeGame.isGameContinue()).isEqualTo(false);
        assertThat(bridgeGame.isGameSuccess()).isEqualTo(false);
    }

    @Test
    void retry_실패_후_재시도_반환값_확인() {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 4);

        // when_1
        bridgeGame.move("D");

        // then_1
        assertThat(bridgeGame.isGameContinue()).isEqualTo(false);
        assertThat(bridgeGame.getTrialCount()).isEqualTo(1);

        // when_2
        bridgeGame.retry();

        // then_2
        assertThat(bridgeGame.isGameContinue()).isEqualTo(true);
        assertThat(bridgeGame.getTrialCount()).isEqualTo(2);
    }

    @Test
    void retry_현재_인덱스_및_시도_횟수_반환_확인() {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1,0,1,1,0,1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 6);

        // when
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");

        // then
        assertThat(bridgeGame.getCurrentIndex()).isEqualTo(4);
        assertThat(bridgeGame.getTrialCount()).isEqualTo(3);
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