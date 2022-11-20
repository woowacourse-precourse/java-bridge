package bridge;

import bridge.dto.PathDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.Command.RETRY;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class BridgeGameTest {
    private static final BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("사용자가 칸을 이동")
    void move() {
        List<PathDTO> user = new ArrayList<>();
        bridgeGame.move(user, any(), any());

        assertEquals(1, user.size());
    }

    @Test
    @DisplayName("사용자가 게임을 다시 시도")
    void retry() {
        String input = RETRY.getName();

        assertTrue(bridgeGame.retry(input));
    }
}