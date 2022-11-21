package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {
    @Test
    @DisplayName("다리 연결 테스트")
    void validateConcatBridge() {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        bridgeMap.concatComponent("[");
        bridgeMap.concatComponent("]");
        assertThat(bridgeMap.toString()).isEqualTo("[]");
    }
}
