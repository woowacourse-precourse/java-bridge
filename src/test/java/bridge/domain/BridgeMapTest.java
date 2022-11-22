package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BridgeMapTest {

    @DisplayName("다리 생성 반영 테스트")
    @Test
    void reflectAtMapTest() {
        BridgeMap bridgeMap = new BridgeMap(3);
        BridgeStatus[][] bridgeStatuses = bridgeMap.bridgeStatuses;
        IntStream.range(0, bridgeStatuses.length)
                .forEach(first ->
                        IntStream.range(0, 3).forEach(second ->
                                assertEquals(BridgeStatus.INIT, bridgeStatuses[first][second])
                        )
                );

        bridgeMap.reflectAtMap("U", 0, BridgeStatus.SUCCESS);
        bridgeMap.reflectAtMap("D", 1, BridgeStatus.FAIL);

        assertEquals(BridgeStatus.SUCCESS, bridgeStatuses[0][0]);
        assertNotEquals(BridgeStatus.FAIL, bridgeStatuses[0][0]);
        assertEquals(BridgeStatus.FAIL, bridgeStatuses[1][1]);
    }

}