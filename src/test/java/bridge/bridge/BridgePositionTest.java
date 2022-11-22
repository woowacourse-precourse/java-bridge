package bridge.bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BridgePositionTest {
    @Test
    public void bridgePositionFromStringSuccessTest() throws Exception {
        // given
        String position = "U";

        // when
        BridgePosition bridgePosition = BridgePosition.fromString(position);

        // then
        assertThat(bridgePosition).isEqualTo(BridgePosition.BRIDGE_UP);
    }

    @Test
    public void bridgePositionFromStringFailTest() throws Exception {
        // given
        String position = "Z";

        // when

        // then
        assertThatThrownBy(() -> BridgePosition.fromString(position)).isInstanceOf(IllegalArgumentException.class);
    }
}