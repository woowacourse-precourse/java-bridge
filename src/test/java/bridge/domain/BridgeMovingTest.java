package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.lang.model.element.ModuleElement;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeMovingTest {
    private static BridgeMoving bridgeMoving;
    private static BridgeIndex bridgeIndex;
    private static int index;

    @BeforeAll
    static void setUp() {
        index = 0;
        BridgeSize bridgeSize = new BridgeSize(5);
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "D"));
        bridgeIndex = new BridgeIndex();
        bridgeMoving = new BridgeMoving(bridge, bridgeSize, bridgeIndex);
    }

    @DisplayName("이동할 칸 입력값을 받아 다리의 칸을 이동한다.")
    @ParameterizedTest
    @CsvSource({"U,O", "U,X", "D,O", "U,O", "U,X"})
    void moveBridge(String shape, String expected) {
        Direction direction = Direction.of(shape);
        assertThat(bridgeMoving.move(direction).getResult()).isEqualTo(expected);
        assertThat(bridgeIndex.getIndex()).isEqualTo(++index);
    }
}
