package bridge.domain.history;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.history.BridgeMoveHistory;
import bridge.domain.history.BridgeGameHistory;
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
        bridgeGameHistory = new BridgeGameHistory();
    }
    
    @DisplayName("addMoveHistory 메소드는 생성되지 않은 history를 대상으로 실행하면 예외를 던진다.")
    @Test
    void addMoveHistoryByNotCreatedHistory() {
        assertThatThrownBy(() -> bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("getMoveResultByTryCount 메소드는 성공한 이동의 경우 O, 선택되지 않은 경우 공백으로 된 방향별 HashMap을 반환한다.")
    @Test
    void getMoveResultByTryCountByValid() {
        bridgeGameHistory.createHistory(1);
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        
        Map<BridgeMove, List<String>> expected = new HashMap<>();
        
        expected.put(BridgeMove.DOWN, List.of(" O ", "   ", "   "));
        expected.put(BridgeMove.UP, List.of("   ", " O ", " O "));
        
        assertThat(bridgeGameHistory.getMoveResultByTryCount(1)).isEqualTo(expected);
    }
    
    @DisplayName("getMoveResultByTryCount 메소드는 성공한 실패의 경우 X, 선택되지 않은 경우 공백으로 된 방향별 HashMap을 반환한다.")
    @Test
    void getMoveResultByTryCountWithFailure() {
        bridgeGameHistory.createHistory(1);
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, false));
        
        Map<BridgeMove, List<String>> expected = new HashMap<>();
        
        expected.put(BridgeMove.DOWN, List.of(" O ", "   ", " X "));
        expected.put(BridgeMove.UP, List.of("   ", " O ", "   "));
        
        assertThat(bridgeGameHistory.getMoveResultByTryCount(1)).isEqualTo(expected);
    }
    
    @DisplayName("getBestRecord 메소드는 성공한 이동이 가장 많은 순으로 정렬하여 tryCount를 반환한다.")
    @Test
    void getBestRecordByMoveCount() {
    
        bridgeGameHistory.createHistory(1);
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
    
        bridgeGameHistory.createHistory(2);
        bridgeGameHistory.addMoveHistory(2, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(2, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(2, new BridgeMoveHistory(BridgeMove.UP, false));
        
        assertThat(bridgeGameHistory.getTryCountOfBestRecord()).isEqualTo(1);
    }
    
    
    @DisplayName("getBestRecord 메소드는 성공한 이동 수가 같을 때 가장 최근 tryCount를 반환한다.")
    @Test
    void getBestRecordByRecentlyTry() {
        
        bridgeGameHistory.createHistory(1);
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
        
        bridgeGameHistory.createHistory(2);
        bridgeGameHistory.addMoveHistory(2, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(2, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(2, new BridgeMoveHistory(BridgeMove.DOWN, true));
        
        assertThat(bridgeGameHistory.getTryCountOfBestRecord()).isEqualTo(2);
    }
}
