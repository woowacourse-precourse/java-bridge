package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.MovingPossibility;
import bridge.domain.controller.BridgeGame;
import bridge.domain.model.Bridge;
import bridge.domain.model.CrossRecord;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    final int MOVE_SPACE = 0;
    final String CAN_MOVE_DIRECTION = "U";
    final String CAN_NOT_MOVE_DIRECTION = "D";

    @BeforeAll
    static void setTestBridge() {
        List<String> testBridge = new ArrayList<>(List.of("U", "D", "D"));
        Bridge.setBridge(testBridge);
    }

    @AfterEach
    void resetCrossRecord() {
        CrossRecord.resetCrossedBridge();
    }

    @DisplayName("이동 기능 - 이동 가능할 경우 CAN_MOVE를 반환한다.")
    @Test
    void returnCanMoveTest() {
        assertThat(bridgeGame.move(MOVE_SPACE, CAN_MOVE_DIRECTION)).isEqualTo(
                MovingPossibility.CAN_MOVE);
    }

    @DisplayName("이동 기능 - 이동 불가능할 경우 CAN_NOT_MOVE를 반환한다.")
    @Test
    void returnCanNotMoveTest() {
        assertThat(bridgeGame.move(MOVE_SPACE, CAN_NOT_MOVE_DIRECTION)).isEqualTo(
                MovingPossibility.CAN_NOT_MOVE);
    }

    @DisplayName("이동 기능 - 이동한 결과를 CrossRecord에 반영한다. - 이동 가능 테스트")
    @Test
    void reflectCanMoveToCrossRecordTest() {
        final String UP_BRIDGE = "[ O ]";
        final String DOWN_BRIDGE = "[   ]";
        List<String> expectedBridge = makeBridgeRecord(UP_BRIDGE, DOWN_BRIDGE);

        bridgeGame.move(MOVE_SPACE, CAN_MOVE_DIRECTION);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("이동 기능 - 이동한 결과를 CrossRecord에 반영한다. - 이동 불가능 테스트")
    @Test
    void reflectCanNotMoveToCrossRecordTest() {
        final String UP_BRIDGE = "[ X ]";
        final String DOWN_BRIDGE = "[   ]";
        List<String> expectedBridge = makeBridgeRecord(UP_BRIDGE, DOWN_BRIDGE);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    List<String> makeBridgeRecord(String upBridge, String downBridge) {
        return new ArrayList<>(List.of(upBridge, downBridge));
    }
}
