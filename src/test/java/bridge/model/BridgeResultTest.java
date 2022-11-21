package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeResultTest {

    @Test
    void isRightLastResult() {
        assertThat(new BridgeResult(List.of(false)).getLast()).isEqualTo(false);
        assertThat(new BridgeResult(List.of(true, true)).getLast()).isEqualTo(true);
        assertThat(new BridgeResult(List.of(true, true, false)).getLast()).isEqualTo(false);
        assertThat(new BridgeResult(List.of(true, true, true)).getLast()).isEqualTo(true);
    }

    @Test
    void checkSuccess() {
        Bridge bridge = new Bridge(List.of("U", "D", "u"));
        assertThat(new BridgeResult(List.of(true, true, true)).checkSuccess(bridge)).isEqualTo(true);
        assertThat(new BridgeResult(List.of(true, true, false)).checkSuccess(bridge)).isEqualTo(false);
        assertThat(new BridgeResult(List.of(true, true)).checkSuccess(bridge)).isEqualTo(false);
        assertThat(new BridgeResult(List.of(true, false)).checkSuccess(bridge)).isEqualTo(false);
    }
}
