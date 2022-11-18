package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D", "D", "U", "D"));
    }

    @DisplayName("한칸 이동 성공 테스트")
    @Test
    void 한칸이동_성공_테스트() {
        assertTrue(bridgeGame.move("U"));
        assertTrue(bridgeGame.move("D"));
        assertTrue(bridgeGame.move("D"));
        assertTrue(bridgeGame.move("D"));
        assertTrue(bridgeGame.move("U"));
        assertTrue(bridgeGame.move("D"));
    }

    @DisplayName("한칸 이동 실패 테스트")
    @Test
    void 한칸이동_실패_테스트() {
        assertFalse(bridgeGame.move("D"));
        assertFalse(bridgeGame.move("U"));
        assertFalse(bridgeGame.move("U"));
        assertFalse(bridgeGame.move("U"));
        assertFalse(bridgeGame.move("D"));
        assertFalse(bridgeGame.move("U"));
    }
}