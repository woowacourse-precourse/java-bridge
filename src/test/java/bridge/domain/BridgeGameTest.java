package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeMaker bridgeMaker;
    List<String> bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(3);
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    void testMoveUntilEnd() {
        bridgeGame.move(bridge.get(0));
        bridgeGame.move(bridge.get(1));
        bridgeGame.move(bridge.get(2));
        assertEquals(true, bridgeGame.isEnd());
    }

    @Test
    void testMoveUntilStop() {
        bridgeGame.move(bridge.get(0));
        bridgeGame.move(oppositeDirection(bridge.get(1)));
        assertFalse(bridgeGame.isEnd());
        assertTrue(bridgeGame.isStopped());
    }

    private String oppositeDirection(String direction) {
        if (direction == "U")
            return "D";
        return "U";
    }
}