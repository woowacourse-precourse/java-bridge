package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.Model.Bridge;
import bridge.Model.BridgeMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BridgeMapTest {

    private Bridge rightBridge;
    private BridgeMap bridgeMap;
    private BridgeMap resultBridgeMap;

    @BeforeEach
    void init() {
        rightBridge = new Bridge(List.of("U","D","D"));
        bridgeMap = new BridgeMap();
        resultBridgeMap = new BridgeMap();
        resultBridgeMap.isCrossUp(rightBridge, 0);
        resultBridgeMap.isCrossDown(rightBridge, 1);
        resultBridgeMap.isCrossDown(rightBridge, 2);
    }

    @Test
    void 다리_건너기_테스트() {
        bridgeMap.isCrossUp(rightBridge, 0);
        bridgeMap.isCrossDown(rightBridge, 1);
        bridgeMap.isCrossDown(rightBridge,2);
        assertThat(bridgeMap.toString()).isEqualTo(resultBridgeMap.toString());
    }
}
