package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.Direction;
import bridge.constants.MovingPossibility;
import bridge.domain.model.CrossRecord;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class CrossRecordTest {

    final String EMPTY_BRIDGE = "[  ]";

    @BeforeEach
    void resetCrossRecord() {
        CrossRecord.resetCrossedBridge();
    }

    @DisplayName("반환 기능 - 다리 기록을 반환한다.")
    @Test
    void getCrossedBridgeTest() {
        Map<Direction, String> expectedBridge = new HashMap<>();
        expectedBridge.put(Direction.UP, EMPTY_BRIDGE);
        expectedBridge.put(Direction.DOWN, EMPTY_BRIDGE);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("기록 기능 - 이동 가능한 경우 O 문자를 기록한다.")
    @ParameterizedTest
    @EnumSource(value = MovingPossibility.class, names = "CAN_MOVE")
    void recordCrossedBridgeWithCanMoveTest(MovingPossibility MOVING_POSSIBILITY) {
        final String UP_BRIDGE = "[ O |   ]";
        final String DOWN_BRIDGE = "[   | O ]";

        Map<Direction, String> expectedBridge = setExpectedBridge(UP_BRIDGE, DOWN_BRIDGE);

        CrossRecord.recordCrossedBridge(Direction.UP, MOVING_POSSIBILITY);
        CrossRecord.recordCrossedBridge(Direction.DOWN, MOVING_POSSIBILITY);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("기록 기능 - 이동 불가능한 경우 X 문자를 기록한다.")
    @ParameterizedTest
    @EnumSource(value = MovingPossibility.class, names = "CAN_NOT_MOVE")
    void recordCrossedBridgeWithCanNotMoveTest(MovingPossibility MOVING_POSSIBILITY) {
        final String UP_BRIDGE = "[ X |   ]";
        final String DOWN_BRIDGE = "[   | X ]";

        Map<Direction, String> expectedBridge = setExpectedBridge(UP_BRIDGE, DOWN_BRIDGE);

        CrossRecord.recordCrossedBridge(Direction.UP, MOVING_POSSIBILITY);
        CrossRecord.recordCrossedBridge(Direction.DOWN, MOVING_POSSIBILITY);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    Map<Direction, String> setExpectedBridge(String upBridge, String downBridge) {
        Map<Direction, String> expectedBridge = new HashMap<>();
        expectedBridge.put(Direction.UP, upBridge);
        expectedBridge.put(Direction.DOWN, downBridge);

        return expectedBridge;
    }

    @DisplayName("초기화 기능 - 지금까지 기록된 다리 문자열을 초기화 한다.")
    @Test
    void resetCrossedBridgeTest() {
        Map<Direction, String> expectedEmptyBridge = new HashMap<>();
        expectedEmptyBridge.put(Direction.UP, EMPTY_BRIDGE);
        expectedEmptyBridge.put(Direction.DOWN, EMPTY_BRIDGE);

        CrossRecord.recordCrossedBridge(Direction.UP, MovingPossibility.CAN_MOVE);
        assertThat(CrossRecord.getCrossedBridge()).isNotEqualTo(expectedEmptyBridge);

        CrossRecord.resetCrossedBridge();
        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedEmptyBridge);
    }
}
