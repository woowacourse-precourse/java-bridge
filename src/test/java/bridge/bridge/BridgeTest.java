package bridge.bridge;

import bridge.BridgeMaker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @Test
    public void makeBridgeTest() {
        List<Integer> bridgeNumbers = List.of(1, 0, 1, 0, 1);
        BridgeMaker bridgeMaker = makeTestBridge(bridgeNumbers);
        List<String> bridge = bridgeMaker.makeBridge(bridgeNumbers.size());
        assertThat(bridge).isEqualTo(new ArrayList<>(List.of("D", "U", "D", "U", "D")));
    }

    private BridgeMaker makeTestBridge(List<Integer> bridge) {
        return new BridgeMaker(new TestBridgeGenerator(bridge));
    }
}
