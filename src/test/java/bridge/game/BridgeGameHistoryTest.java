package bridge.game;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;

import bridge.BridgeMaker;
import bridge.BridgeMove;
import bridge.domain.BridgeMoveHistory;
import bridge.domain.TestNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGameHistory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameHistoryTest {
    
    BridgeGameHistory bridgeGameHistory;
    
    @BeforeEach
    void setUp() {
        final List<BridgeMove> expectMoves = List.of(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP,
                BridgeMove.UP,
                BridgeMove.DOWN
        );
        List<Integer> generateNumbers = newArrayList(expectMoves.stream().map(BridgeMove::getGenerateNumber).collect(
                Collectors.toList()));
        Bridge bridge =
                new Bridge(
                        new BridgeMaker(new TestNumberGenerator(generateNumbers)).makeBridge(generateNumbers.size()));
        
        bridgeGameHistory = new BridgeGameHistory(bridge);
    }
    
    @DisplayName("createHistory 메소드는 시도 횟수에 대한 새로운 비어있는 history list를 생성한다.")
    @Test
    void createHistoryByValid() {
        bridgeGameHistory.createHistory(1);
        assertThat(bridgeGameHistory.getMoveCount(1)).isEqualTo(0);
    }
    
    @DisplayName("getMoveCount 메소드는 이동을 성공한 수를 반환한다.")
    @Test
    void getMoveCountByValid() {
        bridgeGameHistory.createHistory(1);
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.UP, true));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, false));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, false));
        bridgeGameHistory.addMoveHistory(1, new BridgeMoveHistory(BridgeMove.DOWN, false));
        
        assertThat(bridgeGameHistory.getMoveCount(1)).isEqualTo(3);
    }
    
    @DisplayName("getMoveCount 메소드는 생성되지 않은 history를 대상으로 실행하면 예외를 던진다.")
    @Test
    void getMoveCountByNotCreatedHistory() {
        assertThatThrownBy(() -> bridgeGameHistory.getMoveCount(1))
                .isInstanceOf(IllegalArgumentException.class);
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
}
