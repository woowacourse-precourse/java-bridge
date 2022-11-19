package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.MovingDirection;
import bridge.constants.MovingPossibility;
import bridge.domain.controller.BridgeGame;
import bridge.domain.model.Bridge;
import bridge.domain.model.CrossRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    final int MOVE_SPACE = 0;

    @BeforeAll
    static void setTestBridge() {
        List<String> testBridge = new ArrayList<>(List.of("U", "D", "D"));
        Bridge.setBridge(testBridge);
    }

    @BeforeEach
    void resetCrossRecord() {
        CrossRecord.resetCrossedBridge();
    }

    @DisplayName("이동 기능 - 이동 가능할 경우 CAN_MOVE를 반환한다.")
    @Test
    void returnCanMoveTest() {
        assertThat(bridgeGame.move(MOVE_SPACE, MovingDirection.UP)).isEqualTo(
                MovingPossibility.CAN_MOVE);
    }

    @DisplayName("이동 기능 - 이동 불가능할 경우 CAN_NOT_MOVE를 반환한다.")
    @Test
    void returnCanNotMoveTest() {
        assertThat(bridgeGame.move(MOVE_SPACE, MovingDirection.DOWN)).isEqualTo(
                MovingPossibility.CAN_NOT_MOVE);
    }

    @DisplayName("이동 기능 - 이동한 결과를 CrossRecord에 반영한다. - 이동 가능 테스트")
    @Test
    void reflectCanMoveToCrossRecordTest() {
        final String UP_BRIDGE = "[ O ]";
        final String DOWN_BRIDGE = "[   ]";
        Map<MovingDirection, String> expectedBridge = makeBridgeRecord(UP_BRIDGE, DOWN_BRIDGE);

        bridgeGame.move(MOVE_SPACE, MovingDirection.UP);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("이동 기능 - 이동한 결과를 CrossRecord에 반영한다. - 이동 불가능 테스트")
    @Test
    void reflectCanNotMoveToCrossRecordTest() {
        final String UP_BRIDGE = "[   ]";
        final String DOWN_BRIDGE = "[ X ]";
        Map<MovingDirection, String> expectedBridge = makeBridgeRecord(UP_BRIDGE, DOWN_BRIDGE);

        bridgeGame.move(MOVE_SPACE, MovingDirection.DOWN);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    Map<MovingDirection, String> makeBridgeRecord(String upBridge, String downBridge) {
        Map<MovingDirection, String> bridgeRecord = new HashMap<>();
        bridgeRecord.put(MovingDirection.UP, upBridge);
        bridgeRecord.put(MovingDirection.DOWN, downBridge);
        return bridgeRecord;
    }
}
