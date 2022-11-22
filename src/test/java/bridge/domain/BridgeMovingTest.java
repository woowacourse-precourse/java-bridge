package bridge.domain;

import bridge.domain.value.MovingShape;
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
        BridgeIndex bridgeIndex = new BridgeIndex();
        bridgeMoving = new BridgeMoving(bridge, bridgeIndex);
    }

    @DisplayName("이동할 칸 입력값을 받아 다리의 칸을 이동한다.")
    @ParameterizedTest
    @CsvSource({"U,O", "U,X", "D,O", "U,O", "U,X"})
    void moveBridge(String shape, String expected) {
        MovingShape movingShape = new MovingShape(shape);
        assertThat(bridgeMoving.move(movingShape)).isEqualTo(expected);
    }
}
