package bridge;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.domain.BridgeGame;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final List<String> bridge = bridgeMaker.makeBridge(3);

    @DisplayName("이동 결과 O, X 테스트")
    @Test
        // bridge 현재 값은 [U, D, D]
    void moveTest() {
        String firstMove = bridgeGame.move(bridge.get(0), "U");
        String secondMove = bridgeGame.move(bridge.get(1), "D");
        String thirdMove = bridgeGame.move(bridge.get(2), "U");
        assertEquals("O", firstMove);
        assertEquals("O", secondMove);
        assertNotEquals("O", thirdMove);
    }

    @DisplayName("retry() 메서드 테스트")
    @Test
    void retryTest() {
        String moveSuccess = "O";
        String moveFail = "X";
        assertTrue(bridgeGame.retry(moveSuccess));
        assertFalse(bridgeGame.retry(moveFail));
    }
}
