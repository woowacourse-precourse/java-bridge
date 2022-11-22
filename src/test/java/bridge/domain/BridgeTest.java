package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {
    @DisplayName("다리가 안전한지 확인하는 기능")
    @Test
    public void 다리_안전_확인() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));
        assertThat(bridge.isSafe(0, "U")).isTrue();
        assertThat(bridge.isSafe(2, "U")).isFalse();
    }
}