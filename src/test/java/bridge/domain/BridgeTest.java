package bridge.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class BridgeTest {

    @DisplayName("생성된 다리 길이는 지정된 길이와 같다.")
    @Test
    void 다리_길이는_지정된_길이() {
        int bridgeSize = 6;
        Bridge bridge = new Bridge(bridgeSize, new BridgeMaker(new BridgeRandomNumberGenerator()));
        assertThat(bridge)
                .extracting("bridge", InstanceOfAssertFactories.LIST)
                .hasSize(bridgeSize);
    }
}