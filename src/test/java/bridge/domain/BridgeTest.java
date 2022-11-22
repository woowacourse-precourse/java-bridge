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
}