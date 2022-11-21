package bridge;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BridgeTest {
    Logger logger = LoggerFactory.getLogger(Bridge.class);
    @DisplayName("Bridge 생성 테스트")
    @Test
    public void generateTest(){
        Bridge bridge = new Bridge();
        assertNotNull(bridge);
    }
}
