package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {

    @DisplayName("다리 생성 반영 테스트")
    @Test
    void reflectAtMapTest() {
        BridgeMap bridgeMap = new BridgeMap(3);
        BridgeStatus[][] bridgeStatuses = bridgeMap.bridgeStatuses;
        IntStream.range(0, bridgeStatuses.length)
                .forEach(first -> IntStream.range(0, 3)
                        .forEach(second -> assertEquals(bridgeStatuses[first][second], BridgeStatus.INIT)));

        bridgeMap.reflectAtMap("U", 0, BridgeStatus.SUCCESS);
        bridgeMap.reflectAtMap("D", 1, BridgeStatus.FAIL);

        assertEquals(bridgeStatuses[0][0], BridgeStatus.SUCCESS);
        assertNotEquals(bridgeStatuses[0][0], BridgeStatus.FAIL);
        assertEquals(bridgeStatuses[1][1], BridgeStatus.FAIL);
    }

}