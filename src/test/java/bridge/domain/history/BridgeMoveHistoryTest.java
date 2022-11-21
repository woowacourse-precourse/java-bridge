package bridge.domain.history;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.bridge.BridgeMove;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMoveHistoryTest {
    
    BridgeMoveHistory bridgeMoveHistory;
    
    @BeforeEach
    void setUp() {
        bridgeMoveHistory = new BridgeMoveHistory();
    }
    
    @DisplayName("getResults 메소드는 add 메소드로 추가된 BridgeMoveResult 인스턴스를 리스트로 반환해야 한다.")
    @Test
    void getResults() {
        
        List<BridgeMoveResult> expected = List.of(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE));
        
        expected.forEach(bridgeMoveResult -> {
            bridgeMoveHistory.add(bridgeMoveResult);
        });
        
        assertThat(bridgeMoveHistory.getResults()).isEqualTo(expected);
    }
    
    @DisplayName("size 메소드는 add 메소드로 추가된 BridgeMoveResult 인스턴스 리스트의 사이즈를 반환해야 한다.")
    @Test
    void size() {
        
        List<BridgeMoveResult> expected = List.of(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE));
        
        expected.forEach(bridgeMoveResult -> {
            bridgeMoveHistory.add(bridgeMoveResult);
        });
        
        assertThat(bridgeMoveHistory.size()).isEqualTo(expected.size());
    }
    
    @DisplayName("countResultsBySuccess 메소드는 BridgeMoveResult 리스트의 SUCCESS 상태인 값의 수를 반화한다.")
    @Test
    void countResultsBySuccess() {
        
        List<BridgeMoveResult> expected = List.of(new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.FAILURE),
                new BridgeMoveResult(BridgeMove.UP, BridgeMoveResultStatus.SUCCESS));
        
        expected.forEach(bridgeMoveResult -> {
            bridgeMoveHistory.add(bridgeMoveResult);
        });
        
        assertThat(bridgeMoveHistory.countResultsBySuccess()).isEqualTo(2);
    }
}
