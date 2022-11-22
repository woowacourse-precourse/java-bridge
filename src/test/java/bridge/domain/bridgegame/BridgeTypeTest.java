package bridge.domain.bridgegame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTypeTest {

    @Test
    void 다리_타입_찾기_테스트() {
        assertThat(BridgeType.getBridgeType(1)).isEqualTo(BridgeType.UP_VALUE);
        assertThat(BridgeType.getBridgeType(0)).isEqualTo(BridgeType.DOWN_VALUE);
    }

    @Test
    void 다리_타입_찾기_예외_테스트() {
        assertThat(BridgeType.getBridgeType(1)).isNotEqualTo(BridgeType.DOWN_VALUE);
        assertThat(BridgeType.getBridgeType(0)).isNotEqualTo(BridgeType.UP_VALUE);
    }

}