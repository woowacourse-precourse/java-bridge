package bridge.view;

import bridge.domain.BridgeTest;
import bridge.domain.state.Fail;
import bridge.domain.state.MovingResultState;
import bridge.domain.state.Success;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultDisplayTest {
    @Test
    @DisplayName("다리 이동 결과를 출력 로직 관련 enum 데이터로 변환")
    void convertToMoveResult() {
        final Success successState = new Success(BridgeTest.UPPER_BRIDGE, "U");
        final Fail failState = new Fail(BridgeTest.UPPER_BRIDGE, "L");
        final MoveResultDisplay success = MoveResultDisplay.SUCCESS;
        final MoveResultDisplay fail = MoveResultDisplay.FAIL;
        
        final List<MovingResultState> moveMovingResultStates = List.of(successState, failState, successState);
        final List<MoveResultDisplay> expectedMoveResults = List.of(success, fail, success);
        
        assertThat(MoveResultDisplay.convertToMoveResult(moveMovingResultStates)).isEqualTo(expectedMoveResults);
    }
}