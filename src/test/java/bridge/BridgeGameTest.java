package bridge;

import bridge.domain.bridgeGame.BridgeGame;
import bridge.domain.bridgeGame.gameStatus.gameStatics.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    private List<String> bridge;
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridge = new ArrayList<>(List.of("U", "U", "D"));
        bridgeGame = BridgeGame.initGame(bridge);
    }

    @DisplayName("다리 건너기 성공")
    @Test
    void crossSuccess() {
        bridge.forEach(bridgeGame::move);
        String gameResult = bridgeGame.getGameStatics().poll();
        assertThat(gameResult).isEqualTo("성공");
    }

    @DisplayName("다리 건너기 실패")
    @Test
    void crossFail() {
        GameResult gameResult = bridgeGame.move("D");
        assertThat(gameResult.toString()).isEqualTo("실패");
    }
}
