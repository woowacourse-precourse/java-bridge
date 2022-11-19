package domain;

import bridge.entity.Bridge;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    Bridge bridge;

    @Test
    void BridgeTest() {
        bridge = bridge.getInstance(3);
        System.out.println(bridge);
    }
}
