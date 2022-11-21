package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeMovingTest {
    private BridgeMoving bridgeMoving;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "D"));
        bridgeMoving = new BridgeMoving(bridge);
    }

    @DisplayName("이동할 칸 입력값을 받아 다리의 칸을 이동한다.")
    @ParameterizedTest
    @CsvSource({"U,0,O", "U,1,X", "D,2,O", "U,3,O", "U,4,X"})
    void moveBridge(String moving, int movingIndex, String expected) {
        assertThat(bridgeMoving.move(moving, movingIndex)).isEqualTo(expected);
    }
}
