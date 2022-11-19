package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeResultTest {

    @Test
    void recordResult() {
        BridgeResult bridgeResult = new BridgeResult(new ArrayList<>(),new ArrayList<>());
        bridgeResult.recordResult("O","U");
        assertThat(bridgeResult.getUpSpace()).isEqualTo(List.of("O"));
    }
}