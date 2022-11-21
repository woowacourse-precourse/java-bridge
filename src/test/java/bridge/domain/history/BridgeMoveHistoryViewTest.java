package bridge.domain.history;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.bridge.BridgeMove;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMoveHistoryViewTest {
    
    BridgeMoveHistoryView bridgeMoveHistoryView;
    
    @BeforeEach
    void setUp() {
        BridgeMoveHistory bridgeMoveHistory = new BridgeMoveHistory();
        List<BridgeMoveResult> expected = List.of(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE));
    
        expected.forEach(bridgeMoveHistory::add);
    
    
        bridgeMoveHistoryView = new BridgeMoveHistoryView(bridgeMoveHistory);
    }
    
    @DisplayName("getResultMap 메소드는 이동 방향 별로 사이드로 나누어 O, X로 성공, 실패의 출력 문자열 Map을 반환한다.")
    @Test
    void getResultMap() {
        Map<BridgeMove, List<String>> expected = new HashMap<>();
        
        expected.put(BridgeMove.UP, List.of(
                BridgeMoveResultStatus.SUCCESS.getOutput(),
                BridgeMoveResultStatus.SUCCESS.getOutput(),
                BridgeMoveResultStatus.FAILURE.getOutput()));
        
        expected.put(BridgeMove.DOWN, List.of(
                BridgeMoveResultStatus.NOT_SELECTED.getOutput(),
                BridgeMoveResultStatus.NOT_SELECTED.getOutput(),
                BridgeMoveResultStatus.NOT_SELECTED.getOutput()));
        
        assertThat(bridgeMoveHistoryView.getResultMap()).isEqualTo(expected);
    }
}
