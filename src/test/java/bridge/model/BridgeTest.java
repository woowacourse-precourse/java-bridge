package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void isRightMovingWithBridge() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.isRightMoving(0, "U")).isEqualTo(true);
        assertThat(bridge.isRightMoving(1, "U")).isEqualTo(false);
    }

    @Test
    void isBridgeGetSize() {
        assertThat(new Bridge(List.of("U", "D", "D")).getSize()).isEqualTo(3);
        assertThat(new Bridge(List.of("U", "D", "D", "U")).getSize()).isEqualTo(4);
        assertThat(new Bridge(List.of("U", "D", "D", "U", "D")).getSize()).isEqualTo(5);
    }
}
