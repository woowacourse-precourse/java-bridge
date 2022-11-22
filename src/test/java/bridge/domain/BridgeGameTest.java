package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("사용자의 이동 입력이 정답인 경우와 오답인 경우 테스트")
    @Test
    void testMove() {
        List<String> bridge = List.of("U", "U", "U", "D", "U");
        List<String> userBridge = List.of("U", "U", "D", "U", "U");
        assertTrue(bridgeGame.move(bridge.get(0), userBridge.get(0)));
        assertTrue(bridgeGame.move(bridge.get(1), userBridge.get(1)));
        assertFalse(bridgeGame.move(bridge.get(2), userBridge.get(2)));
        assertFalse(bridgeGame.move(bridge.get(3), userBridge.get(3)));
        assertTrue(bridgeGame.move(bridge.get(4), userBridge.get(4)));
    }

    @DisplayName("사용자의 재시작 입력 테스트")
    @Test
    void testRetry() {
        assertTrue(bridgeGame.retry("R"));
        assertFalse(bridgeGame.retry("Q"));
    }
}
