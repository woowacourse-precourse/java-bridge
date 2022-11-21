package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void createBridgeGame() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리 이동 성공 테스트")
    @Test
    void moveBridgeSuccessTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        Result result = bridgeGame.getResult();
        assertEquals("[ O |   | O ]\n" + "[   | O |   ]\n", result.getBridgeMap());
        assertEquals("성공", result.getWinning());
        assertEquals(1, result.getGameCount());
        assertEquals(1, result.getGameCount());
    }
    @DisplayName("다리 이동 실패 테스트")
    @Test
    void moveBridgeFailTest() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry("Q");

        Result result = bridgeGame.getResult();
        assertEquals("[ O | X ]\n" + "[   |   ]\n", result.getBridgeMap());
        assertEquals("실패", result.getWinning());
        assertEquals(1, result.getGameCount());
    }

}