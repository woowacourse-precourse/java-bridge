package bridge.service;

import bridge.model.AnswerBridge;
import bridge.model.MovedBridge;
import bridge.util.Command;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/18
 */
public class MovedBridgeService {
    private static final String START = "[";
    private static final String END = "]";
    private static final String DIVISION = "|";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String NONE = "   ";
    private static final String NEW_LINE = "\n";

    private final GameStatusService gameStatusService = new GameStatusService();
    private final BridgeService bridgeService = new BridgeService();

    public MovedBridge find() {
        return MovedBridge.getInstance();
    }

    public void add(String moveCommand) {
        MovedBridge movedBridge = this.find();
        movedBridge.addMoveBridgeBlock(moveCommand);
        setGameStatus(moveCommand);
    }

    private void setGameStatus(String moveCommand) {
        MovedBridge movedBridge = this.find();
        AnswerBridge bridgeAnswer = bridgeService.find();

        if (!moveCommand.equals(bridgeAnswer.getBridge().get(movedBridge.getSize() - 1))) {
            gameStatusService.setFinishLose();
        } else if (movedBridge.getSize() == bridgeAnswer.getSize()) {
            gameStatusService.setFinishWin();
        }
    }

}
