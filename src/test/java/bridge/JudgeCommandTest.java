package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.model.GameStatus;
import bridge.model.JudgeCommand;
import bridge.model.PresentBridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeCommandTest {

    private GameStatus gameStatus;
    private BridgeMaker bridgeMaker;
    private PresentBridgeMaker presentBridgeMaker;
    private JudgeCommand judgeCommand;

    void init() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        gameStatus = new GameStatus();
        bridgeMaker = new BridgeMaker(numberGenerator);
        presentBridgeMaker = new PresentBridgeMaker();
        gameStatus.initStatus(3);
        bridgeMaker.makeBridge(3);
        judgeCommand = new JudgeCommand(gameStatus, bridgeMaker, presentBridgeMaker);
    }

    @DisplayName("이동 성패 여부 판별")
    @Test
    void judgeMoveCommand() {
        init();
        assertThat(true)
            .isEqualTo(judgeCommand.judgeMove(bridgeMaker.getBridge(), "U", 0));
        assertThat(false)
            .isEqualTo(judgeCommand.judgeMove(bridgeMaker.getBridge(), "D", 0));
        assertThat(true)
            .isEqualTo(judgeCommand.judgeMove(bridgeMaker.getBridge(), "D", 1));
        assertThat(false)
            .isEqualTo(judgeCommand.judgeMove(bridgeMaker.getBridge(), "U", 1));
        assertThat(true)
            .isEqualTo(judgeCommand.judgeMove(bridgeMaker.getBridge(), "D", 2));
        assertThat(false)
            .isEqualTo(judgeCommand.judgeMove(bridgeMaker.getBridge(), "U", 2));

    }

}