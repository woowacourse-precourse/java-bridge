package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(new ArrayList<>());
    }

    @Test
    void 다리_길이_반환_테스트() {
        int testBridgeSize = 3;
        List<String> testBridge = List.of("1", "2", "3");
        bridge = new Bridge(testBridge);

        int bridgeSize = bridge.size();
        assertThat(bridgeSize).isEqualTo(testBridgeSize);
    }

    @Test
    void 다리_윗부분_반환_테스트() {
        List<String> testBridge = List.of("U", "D", "U");
        bridge = new Bridge(testBridge);

        Bridge upBridge = bridge.getUpBridge();
        List<String> expectBridge = List.of("U", " ", "U");
        for (int position = 0; position < bridge.size(); position++) {
            String bridgeShape = upBridge.getBridgeShapeByPosition(position);
            String expectBridgeShape = expectBridge.get(position);
            assertThat(bridgeShape).isEqualTo(expectBridgeShape);
        }
    }
}