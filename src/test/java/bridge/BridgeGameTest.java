package bridge;

import bridge.dto.Bridge;
import bridge.dto.MoveResult;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeGameTest {
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private Long playerId;

    @BeforeEach
    void 세팅() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
        bridgeGame = new BridgeGame();
        playerId = bridgeGame.generatePlayer();
    }

    @DisplayName("플레이어 이동 실패")
    @Test
    void 플레이어_이동_실패() {
        String position = "D";

        MoveResult moveResult = bridgeGame.move(playerId, bridge, position);

        assertTrue(moveResult.isGameOver());
    }

}