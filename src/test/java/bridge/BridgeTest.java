package bridge;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BridgeTest {
    Bridge bridge = new Bridge();
    @DisplayName("Bridge 생성 테스트")
    @Test
    public void generateTest(){
        bridge.inputBridgeNumber();
        assertNotNull(bridge);
    }
}
