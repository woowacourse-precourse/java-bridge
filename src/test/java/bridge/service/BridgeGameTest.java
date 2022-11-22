package bridge.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "U", "D"));

    @Test
    @DisplayName("이동 칸이 같으면 한 칸씩 전진한다.")
    void moveTest() {
        List<String> movings = List.of("U", "D", "U", "U", "D");
        for (String moving : movings) {
            assertTrue(bridgeGame.move(moving));
        }
    }
}
