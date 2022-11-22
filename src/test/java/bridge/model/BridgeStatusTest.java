package bridge.model;

import bridge.view.BridgeBlock;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeStatusTest {
    @Test
    void update() {
        BridgeStatus bridgeStatus = new BridgeStatus();
        for (int i = 0; i < 6; i++) {
            String currPlayer = BridgeBlock.of(i % 2).name();
            boolean correct = (i % 3 == 0);
            bridgeStatus.update(currPlayer, correct);
        }
        assertThat(bridgeStatus.toString()).contains(
                "[   | X |   | O |   | X ]",
                "[ O |   | X |   | X |   ]"
        );
    }

    @Test
    void clear() {
        BridgeStatus bridgeStatus = new BridgeStatus();
        for (int i = 0; i < 10; i++) {
            String currPlayer = BridgeBlock.of(i % 2).name();
            boolean correct = (i % 3 == 0);
            bridgeStatus.update(currPlayer, correct);
        }
        bridgeStatus.clear();

        assertThat(bridgeStatus.toString()).contains("[]");
    }
}