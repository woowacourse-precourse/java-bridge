package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @Test
    void 다리_플레이어_일치_이동가능() {
        Bridge bridge = new Bridge("U", "U");
        assertThat(bridge.isCorrectBridge()).isTrue();

        Bridge bridge2 = new Bridge("D", "D");
        assertThat(bridge2.isCorrectBridge()).isTrue();
    }

    @Test
    void 다리_플레이어_불일치_이동불가() {
        Bridge bridge = new Bridge("U", "D");
        assertThat(bridge.isCorrectBridge()).isFalse();
    }
}
