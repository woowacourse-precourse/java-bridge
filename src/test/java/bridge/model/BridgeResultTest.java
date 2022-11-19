package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeResultTest {

    @Test
    void canMove() {
        assertThat(new BridgeResult(List.of(false)).canMove()).isEqualTo(false);
        assertThat(new BridgeResult(List.of(true, true)).canMove()).isEqualTo(true);
        assertThat(new BridgeResult(List.of(true, true, false)).canMove()).isEqualTo(false);
    }

}