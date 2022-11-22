package bridge.domain;

import bridge.type.BridgeType;
import bridge.type.ResultType;
import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveLogTest {
    MoveLog moveLog = new MoveLog(3);

    @DisplayName("이동 경로가 잘 그려졌는지 확인")
    @Test
    void checkMoveLogAfterUpdate() {
        moveLog.updateMoveLog(BridgeType.UP, ResultType.BLANK.getShape());
        List<String> log = moveLog.getBridgeMoveLog().get(BridgeType.UP);
        Assertions.assertThat(log.size()).isEqualTo(1);
    }

    @DisplayName("경로 삭제가 잘 진행되는지 확인")
    @Test
    void checkMoveLogAfterReset() {
        moveLog.updateMoveLog(BridgeType.UP, ResultType.BLANK.getShape());
        moveLog.updateMoveLog(BridgeType.DOWN, ResultType.SUCCESS.getShape());
        moveLog.updateMoveLog(BridgeType.UP, ResultType.BLANK.getShape());
        moveLog.updateMoveLog(BridgeType.DOWN, ResultType.SUCCESS.getShape());
        List<String> upLog = moveLog.getBridgeMoveLog().get(BridgeType.UP);
        List<String> downLog = moveLog.getBridgeMoveLog().get(BridgeType.DOWN);
        Assertions.assertThat(upLog.size()).isEqualTo(2);
        Assertions.assertThat(downLog.size()).isEqualTo(2);
        moveLog.clearMoveLog();
        List<String> deletedUpLog = moveLog.getBridgeMoveLog().get(BridgeType.UP);
        List<String> deletedDownLog = moveLog.getBridgeMoveLog().get(BridgeType.DOWN);
        Assertions.assertThat(upLog.size()).isEqualTo(0);
        Assertions.assertThat(downLog.size()).isEqualTo(0);
    }

    @DisplayName("아무 것도 저장되어있지 않은 상태로 잘 생성되는지 확인")
    @Test
    void checkMoveLogAfterGenerated() {
        MoveLog testMoveLog = new MoveLog(8);
        List<String> log = testMoveLog.getBridgeMoveLog().get(BridgeType.UP);
        Assertions.assertThat(log.size()).isEqualTo(0);
    }

}