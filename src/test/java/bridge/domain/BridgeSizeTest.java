package bridge.domain;

import static bridge.domain.bridge.BridgeSize.makeBridgeSize;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BridgeSizeTest {

    @Test
    void 다리_길이_예외_테스트() {
        int overSize = 21;
        int underSize = 2;
        int negativeSize = -3;

        assertThatThrownBy(() -> makeBridgeSize(overSize)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> makeBridgeSize(underSize)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> makeBridgeSize(negativeSize)).isInstanceOf(IllegalArgumentException.class);
    }

}