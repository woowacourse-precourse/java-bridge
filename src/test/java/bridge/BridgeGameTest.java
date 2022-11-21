package bridge;

import bridge.core.BridgeGame;
import bridge.core.GameStatusOperator;
import bridge.domain.Bridge;
import bridge.type.FinishCondition;
import bridge.type.GameStatus;
import bridge.type.PassCondition;
import bridge.type.ProcessCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    Bridge bridge;
    GameStatusOperator gameStatusOperator;
    BridgeGame bridgeGame;

    @BeforeEach
    void initTest() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
        gameStatusOperator = GameStatusOperator.initGameStatusOperator();
        bridgeGame = new BridgeGame(bridge, gameStatusOperator);
    }

    @DisplayName("게임 초기화 테스트")
    @Test
    void initBridgeGame() {
        BridgeGame bridgeGame = BridgeGame.initBridgeGame(3);
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        GameStatus gameStatus = gameStatusOperator.getGameStatus();
        Integer numberOfTry = gameStatusOperator.getNumberOfTry();

        assertThat(currentPosition).isEqualTo(-1);
        assertThat(gameStatus).isEqualTo(gameStatus.START);
        assertThat(numberOfTry).isEqualTo(0);
    }

    @DisplayName("다리를 건너기 시작할 때 플레이어가 건널 수 없는 칸을 선택한 경우 FAIL을 반환한다.")
    @Test
    void moveNonPassableBlockFromStart() {
        ProcessCondition passCondition = bridgeGame.move("D");
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(passCondition).isEqualTo(PassCondition.FAIL);
        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("다리를 건너기 시작할 때 플레이어가 건널 수 있는 칸을 선택한 경우 PASS를 반환한다.")
    @Test
    void movePassableBlockFromStart() {
        ProcessCondition passCondition = bridgeGame.move("U");
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(passCondition).isEqualTo(PassCondition.PASS);
        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("다리의 두 번째 칸에 건너기 시작할 때 건널 수 없는 칸을 선택한 경우 FAIL을 반환한다.")
    @Test
    void moveNonPassableBlockFromFirstBlock() {
        movePassableBlockFromStart();
        ProcessCondition passCondition = bridgeGame.move("U");
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(passCondition).isEqualTo(PassCondition.FAIL);
        assertThat(currentPosition).isEqualTo(1);
    }

    @DisplayName("다리의 두 번째 칸에 건너기 시작할 때 건널 수 있는 칸을 선택한 경우 PASS를 반환한다.")
    @Test
    void movePassableBlockFromFirstBlock() {
        movePassableBlockFromStart();
        ProcessCondition passCondition = bridgeGame.move("D");
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(passCondition).isEqualTo(PassCondition.PASS);
        assertThat(currentPosition).isEqualTo(1);
    }

    @DisplayName("다리를 건너다가 건널 수 없는 칸을 선택하고, 재시도를 하면 START를 반환하고 현재 위치는 -1로 초기화된다.")
    @Test
    void retryAfterMovingNonPassableBlock() {
        moveNonPassableBlockFromFirstBlock();
        ProcessCondition gameStatus = bridgeGame.retry();
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(gameStatus).isEqualTo(GameStatus.START);
        assertThat(currentPosition).isEqualTo(-1);
    }

    @DisplayName("플레이어가 다리의 마지막 칸에 도달하면 FINISHED를 반환한다.")
    @Test
    void checkWhetherFinished() {
        IntStream.range(0, 4)
                .forEach(i -> gameStatusOperator.changePosition());
        FinishCondition finishCondition = bridgeGame.checkWhetherFinished();
        assertThat(finishCondition).isEqualTo(FinishCondition.FINISHED);
    }
}