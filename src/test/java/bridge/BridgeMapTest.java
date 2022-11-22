package bridge;

import bridge.domain.bridgeMap.BridgeMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static bridge.BridgeMaker.LOWER_BRIDGE;
import static bridge.BridgeMaker.UPPER_BRIDGE;

public class BridgeMapTest {
    private BridgeMap bridgeMap;

    @BeforeEach
    void setUp() {
        bridgeMap = BridgeMap.initMap();
    }

    @DisplayName("사용자의 이동 결과에 따라 게임 맵 추가")
    @Test
    void addMapElement() {
        bridgeMap.addCrossResult(UPPER_BRIDGE, true);
        bridgeMap.addCrossResult(LOWER_BRIDGE, false);
        assertThat(bridgeMap.toString()).contains("[ O |   ]", "[   | X ]");
    }
}
