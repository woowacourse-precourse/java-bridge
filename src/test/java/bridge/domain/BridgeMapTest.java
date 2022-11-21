/*
package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {

    @DisplayName("다리 건너기 성공 지도맵 생성 테스트")
    @Test
    void successCrossingBridge() {
        Bridge bridge = new Bridge(10);
        boolean winningStatus = true;
        BridgeMap bridgeMap = new BridgeMap(bridge, 5, winningStatus);

        assertFalse(bridgeMap.getMap().contains("X"));
        assertNotNull(bridgeMap.getMap());
    }

    @DisplayName("다리 건너기 실패 지도맵 생성 테스트")
    @Test
    void FailCrossingBridge() {
        Bridge bridge = new Bridge(10);
        boolean winningStatus = false;
        BridgeMap bridgeMap = new BridgeMap(bridge, 5, winningStatus);

        assertTrue(bridgeMap.getMap().contains("X"));
        assertNotNull(bridgeMap.getMap());
    }
}*/
