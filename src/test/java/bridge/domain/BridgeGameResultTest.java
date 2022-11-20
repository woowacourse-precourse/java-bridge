package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {

    @Test
    void create() {
        List<Boolean> actualBooleans = List.of(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
        Bridge actualBridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
        BridgeGameResult actual = new BridgeGameResult(actualBridge, actualBooleans);
        Bridge expectedBridge = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP));
        List<Boolean> expectedBooleans = List.of(true, false, true);
        BridgeGameResult expected = new BridgeGameResult(expectedBridge, expectedBooleans);

        assertThat(actual).isEqualTo(expected);
    }
}
