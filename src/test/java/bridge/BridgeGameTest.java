package bridge;

import bridge.domain.Bridge;
import bridge.type.GameStatus;
import bridge.type.PassCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    Bridge bridge;
    GameStatusOperator gameStatusOperator;
    BridgeGame bridgeGame;

    @BeforeEach
    void initBridgeGame() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
        gameStatusOperator = new GameStatusOperator(-1, 0, GameStatus.START);
        bridgeGame = new BridgeGame(bridge, gameStatusOperator);
    }

    @DisplayName("플레이어가 건널 수 없는 칸을 선택한 경우 FAIL을 반환한다.")
    @Test
    void moveNonPassableBlock() {
        PassCondition passCondition = bridgeGame.move("D");
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(passCondition).isEqualTo(PassCondition.FAIL);
        assertThat(currentPosition).isEqualTo(-1);
    }

    @DisplayName("플레이어가 건널 수 있는 칸을 선택한 경우 PASS를 반환한다.")
    @Test
    void movePassableBlock() {
        PassCondition passCondition = bridgeGame.move("U");
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        assertThat(passCondition).isEqualTo(PassCondition.PASS);
        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("플레이어가 게임을 재시작한다")
    @Test
    void retry() {
        bridgeGame.retry();
        GameStatus gameStatus = gameStatusOperator.getGameStatus();
        assertThat(gameStatus).isEqualTo(GameStatus.RESTART);
    }
}