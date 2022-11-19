package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.MovingDirection;
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
        Map<MovingDirection, String> expectedBridge = new HashMap<>();
        expectedBridge.put(MovingDirection.UP, EMPTY_BRIDGE);
        expectedBridge.put(MovingDirection.DOWN, EMPTY_BRIDGE);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("기록 기능 - 이동 가능한 경우 O 문자를 기록한다.")
    @ParameterizedTest
    @EnumSource(value = MovingPossibility.class, names = "CAN_MOVE")
    void recordCrossedBridgeWithCanMoveTest(MovingPossibility MOVING_POSSIBILITY) {
        final String UP_BRIDGE = "[ O |   ]";
        final String DOWN_BRIDGE = "[   | O ]";

        Map<MovingDirection, String> expectedBridge = setExpectedBridge(UP_BRIDGE, DOWN_BRIDGE);

        CrossRecord.recordCrossedBridge(MovingDirection.UP, MOVING_POSSIBILITY);
        CrossRecord.recordCrossedBridge(MovingDirection.DOWN, MOVING_POSSIBILITY);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("기록 기능 - 이동 불가능한 경우 X 문자를 기록한다.")
    @ParameterizedTest
    @EnumSource(value = MovingPossibility.class, names = "CAN_NOT_MOVE")
    void recordCrossedBridgeWithCanNotMoveTest(MovingPossibility MOVING_POSSIBILITY) {
        final String UP_BRIDGE = "[ X |   ]";
        final String DOWN_BRIDGE = "[   | X ]";

        Map<MovingDirection, String> expectedBridge = setExpectedBridge(UP_BRIDGE, DOWN_BRIDGE);

        CrossRecord.recordCrossedBridge(MovingDirection.UP, MOVING_POSSIBILITY);
        CrossRecord.recordCrossedBridge(MovingDirection.DOWN, MOVING_POSSIBILITY);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    Map<MovingDirection, String> setExpectedBridge(String upBridge, String downBridge) {
        Map<MovingDirection, String> expectedBridge = new HashMap<>();
        expectedBridge.put(MovingDirection.UP, upBridge);
        expectedBridge.put(MovingDirection.DOWN, downBridge);

        return expectedBridge;
    }

    @DisplayName("초기화 기능 - 지금까지 기록된 다리 문자열을 초기화 한다.")
    @Test
    void resetCrossedBridgeTest() {
        Map<MovingDirection, String> expectedEmptyBridge = new HashMap<>();
        expectedEmptyBridge.put(MovingDirection.UP, EMPTY_BRIDGE);
        expectedEmptyBridge.put(MovingDirection.DOWN, EMPTY_BRIDGE);

        CrossRecord.recordCrossedBridge(MovingDirection.UP, MovingPossibility.CAN_MOVE);
        assertThat(CrossRecord.getCrossedBridge()).isNotEqualTo(expectedEmptyBridge);

        CrossRecord.resetCrossedBridge();
        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedEmptyBridge);
    }

    @DisplayName("기록 기능 예외 - 파라미터로 전달된 문자가 U 혹은 D가 아닐 경우 예외가 발생한다.")
    @Test
    void recordCrossedBridgeWithNotUOrDTest() {
        // 예외 처리 과정에서 구현 예정
    }
}
