package bridge.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeTest {

    List<String> bridge = List.of("U", "U", "U", "U", "U", "U");

    @DisplayName("생성된 다리 길이는 지정된 길이와 같다.")
    @Test
    void 다리_길이는_지정된_길이() {
        int bridgeSize = 6;
        Bridge bridge = new Bridge(this.bridge);
        assertThat(bridge)
                .extracting("bridge", InstanceOfAssertFactories.LIST)
                .hasSize(bridgeSize);
    }

    @DisplayName("다리를 이동할 수 있다면 true")
    @Test
    void 이동_가능하면_true() {
        Bridge bridge = new Bridge(this.bridge);
        assertThat(bridge.canMove(0, "U")).isTrue();
    }

    @DisplayName("다리를 이동할 수 없다면 false")
    @Test
    void 이동이_불가능하면_false() {
        Bridge bridge = new Bridge(this.bridge);
        assertThat(bridge.canMove(0, "D")).isFalse();
    }
}