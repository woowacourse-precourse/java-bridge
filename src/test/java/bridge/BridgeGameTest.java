package bridge;

import bridge.domain.Bridge;
import bridge.type.GameStatus;
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

    @DisplayName("플레이어가 다리에서 한 칸 이동한다.")
    @Test
    void move() {
        bridgeGame.move();
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
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