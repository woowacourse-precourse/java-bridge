package bridge.bridge;

import bridge.BridgeMaker;
import bridge.utill.TestBridgeGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @Test
    public void makeBridgeTest() {
        TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator(List.of(1, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(testBridgeGenerator);

        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).isEqualTo(new ArrayList<>(List.of("U", "D", "U", "D", "U")));
    }
}
