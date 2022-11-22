package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("사용자가 이동할 수 있는지 확인")
    @Test
    void testMove() {
        List<String> bridge = List.of("U", "U", "U");
        List<String> userBridge = List.of("U", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        assertTrue(bridgeGame.move(userBridge.get(0), 0).contains(" O "));
        assertFalse(bridgeGame.move(userBridge.get(0), 0).contains(" X "));
        assertTrue(bridgeGame.move(userBridge.get(2), 2).contains(" X "));
    }
}