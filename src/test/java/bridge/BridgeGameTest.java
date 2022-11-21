package bridge;

import bridge.domain.bridgeGame.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = BridgeGame.initGame();
    }

    @DisplayName("재시도 시 게임 통계 업데이트")
    @Test
    void updateGameStatics() {
        bridgeGame.move("U", false);
        Queue<String> gameStatics = bridgeGame.gameStatics();
        assertThat(gameStatics.poll()).isEqualTo("실패");
        bridgeGame.retry();
        bridgeGame.move("D", true);
        gameStatics = bridgeGame.gameStatics();
        assertThat(gameStatics.poll()).isEqualTo("성공");
        assertThat(gameStatics.poll()).isEqualTo("2");
    }
}
