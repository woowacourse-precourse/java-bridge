package bridge.domain.game;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.bridge.BridgeMove;
import bridge.view.OutputView;
import bridge.TestInputView;
import bridge.TestNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameControllerTest {
    
    
    @DisplayName("start 메소드는 모든 칸을 통과하면 정상 종료된다.")
    @Test
    void startByAllPass() {
        List<BridgeMove> expectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP,
                BridgeMove.UP,
                BridgeMove.DOWN
        );
        
        List<BridgeMove> selectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP,
                BridgeMove.UP,
                BridgeMove.DOWN
        );
        getController(5, selectMoves, newArrayList()).start(getTestNumberGenerator(expectMoves));
    }
    
    @DisplayName("start 메소드는 실패 시 RETRY 커맨드를 받으면 처음부터 시작한다.")
    @Test
    void startByRetryCommand() {
        List<BridgeMove> expectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP
        );
        
        List<BridgeMove> selectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.DOWN,
                //
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP
        );
        
        BridgeGameController bridgeGameController = getController(3, selectMoves,
                newArrayList(BridgeGameCommand.RETRY));
        bridgeGameController.start(getTestNumberGenerator(expectMoves));
    }
    
    @DisplayName("start 메소드는 실패 후 RETRY 커맨드를 받고 다시 시도 후 성공을 할 수 있다.")
    @Test
    void startBySuccessAfterRetryCommand() {
        List<BridgeMove> expectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP
        );
        
        List<BridgeMove> selectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.DOWN,
                //
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP
        );
        
        BridgeGameController bridgeGameController = getController(3, selectMoves,
                newArrayList(BridgeGameCommand.RETRY));
        bridgeGameController.start(getTestNumberGenerator(expectMoves));
        assertThat(selectMoves.size()).isEqualTo(0);
    }
    
    @DisplayName("start 메소드는 실패 시 QUIT 커맨드를 받으면 게임을 종료한다.")
    @Test
    void startByQuitCommand() {
        List<BridgeMove> expectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP
        );
        
        List<BridgeMove> selectMoves = newArrayList(
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.DOWN,
                //
                BridgeMove.DOWN,
                BridgeMove.UP,
                BridgeMove.UP
        );
        
        BridgeGameController bridgeGameController = getController(3, selectMoves,
                newArrayList(BridgeGameCommand.QUIT));
        bridgeGameController.start(getTestNumberGenerator(expectMoves));
        assertThat(selectMoves.size()).isEqualTo(3);
    }
    
    TestNumberGenerator getTestNumberGenerator(List<BridgeMove> expectMoves) {
        return new TestNumberGenerator(expectMoves.stream().map(BridgeMove::getGenerateNumber).collect(
                Collectors.toList()));
    }
    
    BridgeGameController getController(int bridgeSize, List<BridgeMove> selectMoves,
            List<BridgeGameCommand> commands) {
        TestInputView testInputView = new TestInputView(
                bridgeSize,
                selectMoves,
                commands
        );
        
        return new BridgeGameController(testInputView, new OutputView());
    }
}
