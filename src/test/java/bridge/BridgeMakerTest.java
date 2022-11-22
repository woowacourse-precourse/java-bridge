package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeMakerTest {
    public static final BridgeMaker UPPER_BRIDGE_MAKER = new BridgeMaker(() -> 1);
    public static final BridgeMaker LOWER_BRIDGE_MAKER = new BridgeMaker(() -> 0);
    
    @Test
    @DisplayName("사다리 생성")
    void createBridge() {
        assertAll(
                () -> assertThat(UPPER_BRIDGE_MAKER.makeBridge(3)).isEqualTo(List.of("U", "U", "U")),
                () -> assertThat(LOWER_BRIDGE_MAKER.makeBridge(3)).isEqualTo(List.of("D", "D", "D"))
        );
    }
}