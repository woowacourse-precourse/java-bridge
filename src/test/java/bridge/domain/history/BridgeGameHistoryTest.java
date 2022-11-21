package bridge.domain.history;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.bridge.BridgeMove;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameHistoryTest {
    
    BridgeGameHistory bridgeGameHistory;
    
    @BeforeEach
    void setUp() {
        bridgeGameHistory = new BridgeGameHistory(1);
    }
    
    @DisplayName("getMoveResultMap 메소드는 성공한 이동의 경우 O, 선택되지 않은 경우 공백으로 된 방향별 HashMap을 반환한다.")
    @Test
    void getMoveResultMapByValid() {
        bridgeGameHistory.addMoveResult(new BridgeMoveResult(BridgeMove.DOWN, BridgeMoveResultStatus.SUCCESS));
        bridgeGameHistory.addMoveResult(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS));
        bridgeGameHistory.addMoveResult(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS));
        
        Map<BridgeMove, List<String>> expected = new HashMap<>();
        
        expected.put(BridgeMove.DOWN, List.of(" O ", "   ", "   "));
        expected.put(BridgeMove.UP, List.of("   ", " O ", " O "));
        
        assertThat(bridgeGameHistory.getMoveResultMap()).isEqualTo(expected);
    }
    
    @DisplayName("getMoveResultMap 메소드는 성공한 실패의 경우 X, 선택되지 않은 경우 공백으로 된 방향별 HashMap을 반환한다.")
    @Test
    void getMoveResultMapWithFailure() {
        bridgeGameHistory.addMoveResult(new BridgeMoveResult(BridgeMove.DOWN, BridgeMoveResultStatus.SUCCESS));
        bridgeGameHistory.addMoveResult(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS));
        bridgeGameHistory.addMoveResult(new BridgeMoveResult(BridgeMove.DOWN, BridgeMoveResultStatus.FAILURE));
        
        Map<BridgeMove, List<String>> expected = new HashMap<>();
        
        expected.put(BridgeMove.DOWN, List.of(" O ", "   ", " X "));
        expected.put(BridgeMove.UP, List.of("   ", " O ", "   "));
        
        assertThat(bridgeGameHistory.getMoveResultMap()).isEqualTo(expected);
    }
}
