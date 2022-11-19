package bridge;

import bridge.domain.game.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setup() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void testBridgeSize() {
        assertEquals( 3, bridgeMaker.makeBridge(3).size());
    }

    @Test
    void testBridgeString() {
        List<String> bridge = bridgeMaker.makeBridge(3);
        for (int i=0; i<3; i++) {
            assertTrue(bridge.get(i).equals(BridgeGame.UP_DIRECTION)
                    || bridge.get(i).equals(BridgeGame.DOWN_DIRECTION));
        }
    }
}