package bridge.utils;

import bridge.domain.BridgeTest;
import bridge.domain.state.Fail;
import bridge.domain.state.State;
import bridge.domain.state.Success;
import bridge.view.MoveResultDisplay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveResultUtilsTest {
    private Success success;
    private Fail fail;
    
    @BeforeEach
    void setUp() {
        success = new Success(BridgeTest.UPPER_BRIDGE, "U");
        fail = new Fail(BridgeTest.UPPER_BRIDGE, "U");
    }
    
    @Test
    @DisplayName("다리 이동 결과를 출력 로직 관련 enum 데이터로 변환")
    void convertToMoveResult() {
        final MoveResultDisplay success = MoveResultDisplay.SUCCESS;
        final MoveResultDisplay fail = MoveResultDisplay.FAIL;
        final List<State> moveStates = List.of(this.success, this.fail, this.success);
        final List<MoveResultDisplay> expectedMoveResults = List.of(success, fail, success);
        
        assertThat(MoveResultUtils.convertToMoveResult(moveStates)).isEqualTo(expectedMoveResults);
    }
}