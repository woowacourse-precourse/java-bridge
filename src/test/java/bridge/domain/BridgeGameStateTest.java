package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameStateTest {

    private BridgeGameState bridgeGameState;

    @BeforeEach
    void init() {
        bridgeGameState = new BridgeGameState();
    }

    @DisplayName("게임 라운드 카운트")
    @Test
    void countGameRound() {
        bridgeGameState.countGameRound();
        assertThat(bridgeGameState.getGameRound()).isEqualTo(BRIDGE_GAME_ROUND_INIT + 1);
    }

    @DisplayName("게임 라운드 초기화")
    @Test
    void initGameRound() {
        bridgeGameState.countGameRound();
        bridgeGameState.initGameRound();
        assertThat(bridgeGameState.getGameRound()).isEqualTo(BRIDGE_GAME_ROUND_INIT);
    }

    @DisplayName("게임 총 도전 횟수 카운트")
    @Test
    void countTotalGameAttempts() {
        bridgeGameState.countTotalGameAttempts();
        assertThat(bridgeGameState.getTotalGameAttempts()).isEqualTo(BRIDGE_GAME_ATTEMPTS_INIT + 1);
    }

    @DisplayName("게임 성공 처리")
    @Test
    void win() {
        bridgeGameState.win();
        assertThat(bridgeGameState.isWon()).isEqualTo(true);
    }

    @DisplayName("게임 실패 처리")
    @Test
    void lose() {
        bridgeGameState.lose();
        assertThat(bridgeGameState.isWon()).isEqualTo(false);
    }
}
