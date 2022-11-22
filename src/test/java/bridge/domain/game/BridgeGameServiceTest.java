package bridge.domain.game;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.domain.bridge.BridgeMove;
import bridge.TestNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameService;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameServiceTest {
    
    BridgeGameService bridgeGameService;
    
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
        bridgeGameService = new BridgeGameService(new BridgeGame(bridge));
    }
    
    
    @DisplayName("isFinish 메소드는 모든 이동이 성공했을 경우 true를 반환한다.")
    @Test
    void isFinishByAllPass() {
        bridgeGameService.tryMove(BridgeMove.DOWN);
        bridgeGameService.tryMove(BridgeMove.UP);
        bridgeGameService.tryMove(BridgeMove.UP);
        bridgeGameService.tryMove(BridgeMove.UP);
        bridgeGameService.tryMove(BridgeMove.DOWN);
        
        assertThat(bridgeGameService.isFinish()).isEqualTo(true);
    }
    
    @DisplayName("isFinish 메소드는 모든 이동이 성공했을 경우 true를 반환한다.")
    @Test
    void isFinishByNotFinish() {
        bridgeGameService.tryMove(BridgeMove.DOWN);
        
        assertThat(bridgeGameService.isFinish()).isEqualTo(false);
    }
    
    @DisplayName("tryMove 메소드는 이동에 실패했을 경우 false를 반환한다.")
    @Test
    void tryMoveByNotCorrectMove() {
        assertThat(bridgeGameService.tryMove(BridgeMove.UP)).isEqualTo(false);
        assertThat(bridgeGameService.tryMove(BridgeMove.UP)).isEqualTo(false);
    }
    
    @DisplayName("tryMove 메소드는 이동에 성공했을 경우 true를 반환한다.")
    @Test
    void tryMoveByAllPass() {
        assertThat(bridgeGameService.tryMove(BridgeMove.DOWN)).isEqualTo(true);
        assertThat(bridgeGameService.tryMove(BridgeMove.UP)).isEqualTo(true);
        assertThat(bridgeGameService.tryMove(BridgeMove.UP)).isEqualTo(true);
        assertThat(bridgeGameService.tryMove(BridgeMove.UP)).isEqualTo(true);
        assertThat(bridgeGameService.tryMove(BridgeMove.DOWN)).isEqualTo(true);
    }
}
