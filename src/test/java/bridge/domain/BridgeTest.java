package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

    @Test
    void canGo() {
        Assertions.assertThat(bridge.canGo(0, "U")).isTrue();
        Assertions.assertThat(bridge.canGo(1, "U")).isFalse();
        Assertions.assertThat(bridge.canGo(2, "U")).isFalse();
        Assertions.assertThat(bridge.canGo(3, "U")).isTrue();
    }
}