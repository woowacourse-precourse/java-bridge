package bridge.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMapTest {

    @DisplayName("다리의 각 칸에 대한 입력의 결과를 추가한다.")
    @Test
    void add() {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.add(true, true);
        bridgeMap.add(true, false);
        bridgeMap.add(false, true);
        bridgeMap.add(false, false);

        assertThat(bridgeMap.toString()).isEqualTo("[ O | X |   |   ]\n[   |   | O | X ]");
    }
}