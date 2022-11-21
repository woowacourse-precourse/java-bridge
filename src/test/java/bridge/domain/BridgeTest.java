package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {
    @DisplayName("특정위치에서 다리가 같으면 true")
    @Test
    void checkSameBridgeByIndex1() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.contain(2, "D");
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("특정위치에서 다리가 다르면 false")
    @Test
    void checkSameBridgeByIndex2() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.contain(0, "D");
        assertThat(result).isEqualTo(false);
    }


    @DisplayName("같은 다리이면 true")
    @Test
    void checkSameBridge1() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.isSame(List.of("U", "D", "D"));
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("다른 다리이면 false")
    @Test
    void checkSameBridge2() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        boolean result = bridge.isSame(List.of("U", "D"));
        assertThat(result).isEqualTo(false);
    }

}
