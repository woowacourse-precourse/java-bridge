package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {

    @DisplayName("BridgeMap은 updateMap을 통해 사용자의 다리 이동을 표시한다.")
    @Test
    void updateMap_정상작동확인() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.updateMap(0, true);
        bridgeMap.updateMap(1, true);
        bridgeMap.updateMap(0, false);
        List<List<String>> answer = List.of(List.of("O", " "), List.of(" ", "O"), List.of("X", " "));
        assertThat(bridgeMap.getMap().toString()).isEqualTo(answer.toString());
    }

    @DisplayName("BridgeMap은 updateMap을 통해 사용자의 다리 이동을 표시한다.")
    @Test
    void updateMap_정상작동확인2() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.updateMap(1, true);
        bridgeMap.updateMap(1, true);
        bridgeMap.updateMap(0, true);
        bridgeMap.updateMap(0, false);
        List<List<String>> answer = List.of(List.of(" ", "O"), List.of(" ", "O"), List.of("O", " "), List.of("X", " "));
        assertThat(bridgeMap.getMap().toString()).isEqualTo(answer.toString());
    }
}
