package bridge.game;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;

import bridge.BridgeMaker;
import bridge.BridgeMove;
import bridge.domain.BridgeMoveHistory;
import bridge.domain.TestNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGameHistory;
import java.util.List;
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
}
