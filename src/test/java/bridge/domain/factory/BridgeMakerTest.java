package bridge.domain.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeMakerTest {
    @Test
    @DisplayName("사다리 생성")
    void createBridge() {
        assertAll(
                () -> assertThat(new BridgeMaker(() -> 1).makeBridge(3)).isEqualTo(List.of("U", "U", "U")),
                () -> assertThat(new BridgeMaker(() -> 0).makeBridge(3)).isEqualTo(List.of("D", "D", "D"))
        );
    }
}