package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "D"));
    }

    @Test
    void isRightMovingWithBridge() {
        assertThat(bridge.isRightMoving(0, "U")).isEqualTo(true);
        assertThat(bridge.isRightMoving(1, "U")).isEqualTo(false);
    }
}
