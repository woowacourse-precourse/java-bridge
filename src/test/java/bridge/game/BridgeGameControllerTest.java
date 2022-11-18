package bridge.game;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.BridgeMove;
import bridge.TestInputView;
import bridge.domain.TestNumberGenerator;
import bridge.domain.game.BridgeGameCommand;
import bridge.domain.game.BridgeGameController;
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
        getController(expectMoves, selectMoves, newArrayList()).start();
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
    
        BridgeGameController bridgeGameController = getController(expectMoves, selectMoves,
                newArrayList(BridgeGameCommand.RETRY));
        bridgeGameController.start();
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
        
        BridgeGameController bridgeGameController = getController(expectMoves, selectMoves,
                newArrayList(BridgeGameCommand.RETRY));
        bridgeGameController.start();
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
        
        BridgeGameController bridgeGameController = getController(expectMoves, selectMoves,
                newArrayList(BridgeGameCommand.QUIT));
        bridgeGameController.start();
        assertThat(selectMoves.size()).isEqualTo(3);
    }
    
    
    BridgeGameController getController(List<BridgeMove> expectMoves, List<BridgeMove> selectMoves,
            List<BridgeGameCommand> commands) {
        List<Integer> generateNumbers = newArrayList(expectMoves.stream().map(BridgeMove::getGenerateNumber).collect(
                Collectors.toList()));
        
        TestInputView testInputView = new TestInputView(
                selectMoves,
                commands
        );
        
        return new BridgeGameController(
                new BridgeMaker(new TestNumberGenerator(generateNumbers)).makeBridge(generateNumbers.size()),
                testInputView
        );
    }
}
