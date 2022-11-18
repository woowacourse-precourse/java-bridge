package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("다리는 U 와 D 로 이루어져 있다.")
    @Test
    void createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> directions = bridgeMaker.makeBridge(10);
        Bridge bridge = new Bridge(directions);

        assertThat(bridge.getDirections().stream()
                .allMatch(direction -> direction.getDirection().equals("U") || direction.getDirection().equals("D")))
                .isTrue();
    }
}