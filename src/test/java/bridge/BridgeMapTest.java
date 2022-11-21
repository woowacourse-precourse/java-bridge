package bridge;

import bridge.domain.bridge.BridgeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {
    @DisplayName("BridgeMap에 데이터를 추가해본다.")
    @Test
    void testBridgeMapAdd() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.add("U", true);
        bridgeMap.add("D", false);
        List<List<String>> result = List.of(List.of("O", " "), List.of(" ", "X"));
        assertThat(bridgeMap.get()).isEqualTo(result);
    }
}
