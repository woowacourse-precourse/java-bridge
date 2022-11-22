package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = createTestBridge();
    }

    @Test
    void 다리_길이_반환_테스트() {
        int bridgeSize = bridge.size();
        int expectBridgeSize = 3;
        assertThat(bridgeSize).isEqualTo(expectBridgeSize);
    }

    @Test
    void 다리_윗부분_반환_테스트() {
        Bridge upBridge = bridge.getUpBridge();
        List<String> expectBridge = List.of("U", " ", "U");
        compareBridge(upBridge, expectBridge);
    }

    @Test
    void 다리_아랫부분_반환_테스트() {
        Bridge downBridge = bridge.getDownBridge();
        List<String> expectBridge = List.of(" ", "D", " ");
        compareBridge(downBridge, expectBridge);
    }

    private Bridge createTestBridge() {
        List<String> bridge = List.of("U", "D", "U");
        return new Bridge(bridge);
    }

    private void compareBridge(Bridge bridge, List<String> expectBridge) {
        for (int position = 0; position < bridge.size(); position++) {
            String bridgeShape = bridge.getBridgeShapeByPosition(position);
            String expectBridgeShape = expectBridge.get(position);
            assertThat(bridgeShape).isEqualTo(expectBridgeShape);
        }
    }
}