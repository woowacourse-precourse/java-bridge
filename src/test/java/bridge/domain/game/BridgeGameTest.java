package bridge.domain.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.game.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private BridgeGame bridgeGame;

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
        assertTrue(bridgeGame.isEnd());
    }

    @Test
    void testMoveUntilStop() {
        bridgeGame.move(bridge.get(0));
        bridgeGame.move(oppositeDirection(bridge.get(1)));
        assertFalse(bridgeGame.isEnd());
        assertTrue(bridgeGame.isStopped());
    }

    @Test
    void testRetry() {
        bridgeGame.move(bridge.get(0));
        bridgeGame.move(bridge.get(1));
        bridgeGame.move(bridge.get(2));
        assertTrue(bridgeGame.isEnd());

        bridgeGame.retry();
        assertFalse(bridgeGame.isEnd());
        assertFalse(bridgeGame.isStopped());
    }

    @Test
    void testReturnEnd() {
        bridgeGame.move(bridge.get(0));
        bridgeGame.move(bridge.get(1));
        bridgeGame.move(oppositeDirection(bridge.get(2)));
        assertFalse(bridgeGame.isEnd());
    }

    private String oppositeDirection(String direction) {
        if (direction.equals("U"))
            return "D";
        return "U";
    }
}