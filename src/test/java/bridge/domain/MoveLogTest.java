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

}