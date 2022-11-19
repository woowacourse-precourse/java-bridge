package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void 다리_길이_테스트() {
        List<String> shorts = List.of("U", "U");
        List<String> longs = List.of("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                "U", "U", "U", "U", "U", "U");

        assertThatThrownBy(() -> Bridge.convert(shorts)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Bridge.convert(longs)).isInstanceOf(IllegalArgumentException.class);
    }
}