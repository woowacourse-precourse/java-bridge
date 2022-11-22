package bridge;

import bridge.domain.bridgeGame.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeTest {
    Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = Bridge.from(List.of("U", "U", "D"));
    }

    @DisplayName("건널 수 있는 방향 조회")
    @Test
    void getPassableDirection() {
        String direction = bridge.passableDirectionAt(0);
        assertThat(direction).isEqualTo("U");
    }
}
