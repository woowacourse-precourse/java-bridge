package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.TestNumberGenerator;
import bridge.domain.BridgeGameStatus;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {

    @DisplayName("다리의 길이만큼 이동했기 때문에 더 이상 이동할 수 없음")
    @Test
    void canNotMoveContinueBecauseMoveEndTest() {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        int bridgeSize = 3;
        bridgeGame.initialize(bridgeSize);
        
        // when
        IntStream.range(0, bridgeSize)
                .forEach(i -> bridgeGame.move(Moving.UP));
        boolean canMove = bridgeGame.canMoveContinue();

        // then
        assertFalse(canMove);
    }

    @DisplayName("잘못된 칸을 입력받아서 더 이상 움직일 수 없음")
    @Test
    void canNotMoveContinueBecauseMoveFailTest() {
        // given
        List<Integer> bridge = newArrayList(1, 1, 0);
        int bridgeSize = bridge.size();
        BridgeGame bridgeGame = createBridgeGame(bridge);
        bridgeGame.initialize(bridgeSize);

        // when
        IntStream.range(0, bridgeSize)
                .forEach(i -> bridgeGame.move(Moving.UP));
        boolean canMove = bridgeGame.canMoveContinue();

        // then
        assertFalse(canMove);
    }

    @DisplayName("게임 move 이후 성공적인 종료 테스트")
    @Test
    void gamePlayerMoveTest() {
        // given
        List<Integer> bridge = newArrayList(1, 1, 0);
        BridgeGame bridgeGame = createBridgeGame(bridge);
        bridgeGame.initialize(bridge.size());
        
        // when
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.DOWN);
        BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();

        // then
        assertTrue(bridgeGameStatus.isGameSuccessfulEnd());
    }

    @DisplayName("게임 move 이후 게임 종료 실패 테스트")
    @Test
    void gamePlayerMoveFailTest() {
        // given
        List<Integer> bridge = newArrayList(1, 1, 0);
        BridgeGame bridgeGame = createBridgeGame(bridge);
        bridgeGame.initialize(bridge.size());

        // when
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.UP);
        BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();

        // then
        assertFalse(bridgeGameStatus.isGameSuccessfulEnd());
    }

    @DisplayName("게임 move 이후 retry 시 playerMove 초기화 테스트")
    @Test
    void gamePlayerMoveRetryClearTest() {
        // given
        List<Integer> bridge = newArrayList(1, 1, 0);
        BridgeGame bridgeGame = createBridgeGame(bridge);
        bridgeGame.initialize(bridge.size());

        // when
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.UP);
        bridgeGame.move(Moving.DOWN);
        bridgeGame.retry(GameCommand.RESTART);
        BridgeGameStatus bridgeGameStatus = bridgeGame.getBridgeGameStatus();

        // then
        assertFalse(bridgeGameStatus.isGameSuccessfulEnd());
    }

    private BridgeGame createBridgeGame(List<Integer> bridge) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(bridge);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return new BridgeGame(bridgeMaker);
    }
}
