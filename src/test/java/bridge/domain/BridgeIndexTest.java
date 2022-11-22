package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeIndexTest {

    @Test
    void initIndex() {
        BridgeIndex bridgeIndex = BridgeIndex.initIndex();
        int result = -1;
        assertThat(bridgeIndex.getIndex()).isEqualTo(result);
    }

    @Test
    void increment() {
        BridgeIndex bridgeIndex = BridgeIndex.initIndex();
        bridgeIndex.increment();
        int result = 0;

        assertThat(bridgeIndex.getIndex()).isEqualTo(result);
    }
}