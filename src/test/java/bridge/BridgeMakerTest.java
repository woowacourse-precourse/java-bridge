package bridge;

import bridge.model.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 생성")
    void makeBridge() {
        int size = 5;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertEquals(size, bridge.size());
        for (int round = 0; round < size; round++) {
            assertTrue(Direction.isDirection(bridge.get(round)));
        }
    }
}