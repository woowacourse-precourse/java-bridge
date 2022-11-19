package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeGameTest {

    @Test
    void move() {
        UpNumberGenerator upNumberGenerator = new UpNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(upNumberGenerator);
        int size = 1;
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        BridgeGame bridgeGame = new BridgeGame(bridge);

        MoveResult result = bridgeGame.move(0, "U");

        assertTrue(result.isMatchResult());
    }

    @Test
    void retry() {
    }
}