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

    @Test
    @DisplayName("마지막 요소 삭제 테스트")
    void validateDeleteLastComponent() {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        bridgeMap.concatComponent("[ O | X |");
        String separator = "|";
        bridgeMap.deleteLastComponent(separator);
        assertThat(bridgeMap.toString()).isEqualTo("[ O | X ");
    }
}
