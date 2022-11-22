package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.Direction;
import bridge.constants.MovingPossibility;
import bridge.domain.controller.BridgeGame;
import bridge.domain.model.Bridge;
import bridge.domain.model.CrossRecord;
import bridge.domain.model.GameResultInformation;
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

    final int ZERO_SPACE = 0;

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
        assertThat(bridgeGame.move(ZERO_SPACE, Direction.UP)).isEqualTo(
                MovingPossibility.CAN_MOVE);
    }

    @DisplayName("이동 기능 - 이동 불가능할 경우 CAN_NOT_MOVE를 반환한다.")
    @Test
    void returnCanNotMoveTest() {
        assertThat(bridgeGame.move(ZERO_SPACE, Direction.DOWN)).isEqualTo(
                MovingPossibility.CAN_NOT_MOVE);
    }

    @DisplayName("이동 기능 - 이동한 결과를 CrossRecord에 반영한다. - 이동 가능 테스트")
    @Test
    void reflectCanMoveToCrossRecordTest() {
        final String UP_BRIDGE = "[ O ]";
        final String DOWN_BRIDGE = "[   ]";
        Map<Direction, String> expectedBridge = makeBridgeRecord(UP_BRIDGE, DOWN_BRIDGE);

        bridgeGame.move(ZERO_SPACE, Direction.UP);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    @DisplayName("이동 기능 - 이동한 결과를 CrossRecord에 반영한다. - 이동 불가능 테스트")
    @Test
    void reflectCanNotMoveToCrossRecordTest() {
        final String UP_BRIDGE = "[   ]";
        final String DOWN_BRIDGE = "[ X ]";
        Map<Direction, String> expectedBridge = makeBridgeRecord(UP_BRIDGE, DOWN_BRIDGE);

        bridgeGame.move(ZERO_SPACE, Direction.DOWN);

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(expectedBridge);
    }

    Map<Direction, String> makeBridgeRecord(String upBridge, String downBridge) {
        Map<Direction, String> bridgeRecord = new HashMap<>();
        bridgeRecord.put(Direction.UP, upBridge);
        bridgeRecord.put(Direction.DOWN, downBridge);
        return bridgeRecord;
    }

    @DisplayName("재시도 기능 - 재시도할 경우, 총 시도 횟수가 증가한다.")
    @Test
    void retryIncreaseCountOfTryTest() {
        int firstCountOfTry = GameResultInformation.getCountOfTry();

        bridgeGame.retry();

        assertThat(GameResultInformation.getCountOfTry()).isEqualTo(firstCountOfTry + 1);
    }

    @DisplayName("재시도 기능 - 재시도할 경우, 이동한 기록이 리셋된다.")
    @Test
    void retryResetCrossedRecordTest() {
        bridgeGame.move(ZERO_SPACE, Direction.UP);
        Map<Direction, String> emptyBridgeRecord = setEmptyBridge();

        assertThat(CrossRecord.getCrossedBridge()).isNotEqualTo(emptyBridgeRecord);

        bridgeGame.retry();

        assertThat(CrossRecord.getCrossedBridge()).isEqualTo(emptyBridgeRecord);
    }

    Map<Direction, String> setEmptyBridge() {
        final String emptyBridge = "[  ]";
        Map<Direction, String> emptyBridgeRecord = new HashMap<>();
        emptyBridgeRecord.put(Direction.UP, emptyBridge);
        emptyBridgeRecord.put(Direction.DOWN, emptyBridge);

        return emptyBridgeRecord;
    }
}
