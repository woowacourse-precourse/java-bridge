package bridge;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 게임실패_test() {
        String result = bridgeGame.retry("Q");
        Assertions.assertEquals(result, "실패");
    }
}
