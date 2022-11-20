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
}
