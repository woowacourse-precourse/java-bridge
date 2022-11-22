package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.Bridge;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @DisplayName("다리 생성 테스트")
    @Test
    void createBridge() {
        Bridge bridge = new Bridge(Arrays.asList("U", "D", "U"));
        assertThat(bridge.getBridge()).isEqualTo(Arrays.asList("U", "D", "U"));
    }
}