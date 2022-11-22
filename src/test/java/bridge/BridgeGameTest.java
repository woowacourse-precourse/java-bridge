package bridge;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    void 게임_실패_test() {
        BridgeGame bridgeGame = new BridgeGame();
        String result = bridgeGame.retry("Q");
        Assertions.assertEquals(result, "실패");
    }
}
