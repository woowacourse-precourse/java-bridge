package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.MovingDirection;
import bridge.domain.model.CrossRecord;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CrossRecordTest {

    CrossRecord crossRecord = new CrossRecord();
    final String UP_DIRECTION = MovingDirection.UP.getDirection();
    final String DOWN_DIRECTION = MovingDirection.DOWN.getDirection();
    final String EMPTY_BRIDGE = "[  ]";

    @DisplayName("반환 기능 - 다리 기록을 반환한다.")
    @Test
    void getCrossedBridgeTest() {
        List<String> expectedBridge = new ArrayList<>(List.of(EMPTY_BRIDGE, EMPTY_BRIDGE));

        assertThat(crossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("기록 기능 - 전달된 파라미터에 따라 다리 문자열을 기록한다.")
    @ParameterizedTest
    @CsvSource({"true, '[ O |   ]', '[   | O ]'",
            "false, '[ X |   ]', '[   | X ]'"})
    void recordCrossedBridgeTest(boolean isSuccess, String upBridge, String downBridge) {
        List<String> expectedBridge = new ArrayList<>(List.of(upBridge, downBridge));

        crossRecord.recordCrossedBridge(UP_DIRECTION, isSuccess);
        crossRecord.recordCrossedBridge(DOWN_DIRECTION, isSuccess);

        assertThat(crossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("초기화 기능 - 지금까지 기록된 다리 문자열을 초기화 한다.")
    @Test
    void resetCrossedBridgeTest() {
        List<String> expectedEmptyBridge = new ArrayList<>(List.of(EMPTY_BRIDGE, EMPTY_BRIDGE));

        crossRecord.recordCrossedBridge(UP_DIRECTION, true);

        assertThat(crossRecord.getCrossedBridge()).isNotEqualTo(expectedEmptyBridge);

        crossRecord.resetCrossedBridge();

        assertThat(crossRecord.getCrossedBridge()).isEqualTo(expectedEmptyBridge);
    }

    @DisplayName("기록 기능 예외 - 파라미터로 전달된 문자가 U 혹은 D가 아닐 경우 예외가 발생한다.")
    @Test
    void recordCrossedBridgeWithNotUOrDTest() {
        // 예외 처리 과정에서 구현 예정
    }
}
