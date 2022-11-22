package bridge;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.MoveType;
import bridge.domain.result.Map;
import bridge.domain.result.Result;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        ArrayList<Integer> numbers = Lists.newArrayList(1, 0, 0);
        Bridge bridge = new Bridge(getTestBridgeMaker(numbers));
        Result result = new Result(new Map());
        bridgeGame = new BridgeGame(bridge, result);
        bridgeGame.createBridge(numbers.size());
    }

    @Test
    @DisplayName("moveType 을 인자로 받아 move 를 요청하면 Result 를 반환해야하고 성공 또는 종료가 lastMoveType 에 담겨야한다.")
    void move_succeed_and_finished() {
        Result actual1 = bridgeGame.move(MoveType.UP);

        Assertions.assertTrue(actual1.isSucceeded());
        Assertions.assertFalse(actual1.isFinished());

        Result actual2 = bridgeGame.move(MoveType.DOWN);

        Assertions.assertTrue(actual2.isSucceeded());
        Assertions.assertFalse(actual2.isFinished());

        Result actual3 = bridgeGame.move(MoveType.DOWN);
        Assertions.assertTrue(actual3.isFinished());
        Assertions.assertFalse(actual3.isSucceeded());
    }

    @Test
    @DisplayName("moveType 을 인자로 받아 move 를 요청하면 Result 를 반환해야하고 fail 이 결과가 담겨야한다.")
    void move_failed() {
        //given
        //when
        Result actual = bridgeGame.move(MoveType.DOWN);
        //then
        Assertions.assertFalse(actual.isSucceeded());
        Assertions.assertFalse(actual.isFinished());
    }


    @Test
    void retry() {
        //초기화후 Result 다시 확인해서 트라이카운터가 증가하는지 확인

    }

    private static BridgeMaker getTestBridgeMaker(List<Integer> numbers) {
        return new BridgeMaker(new TestNumberGenerator(numbers));
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