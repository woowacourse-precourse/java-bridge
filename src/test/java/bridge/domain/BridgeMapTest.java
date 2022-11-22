package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMapTest {
    private final BridgeMap bridgeMap = new BridgeMap();

    @Test
    @DisplayName("지도_초기화_테스트")
    void initial() {
        bridgeMap.createMap(false, "U");
        bridgeMap.initial();
        assertThat(bridgeMap.getMap())
                .hasSize(2)
                .contains(entry("U", new ArrayList<>()), entry("D", new ArrayList<>()));
    }

}