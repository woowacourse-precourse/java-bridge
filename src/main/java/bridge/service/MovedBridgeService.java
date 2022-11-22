package bridge.service;

import bridge.model.AnswerBridge;
import bridge.model.MovedBridge;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/18
 */
public class MovedBridgeService {
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

    public void reset() {
        MovedBridge.getInstance().reset();
        gameStatusService.find().addAttemptCount();
    }

    public String printMap() {
        return BridgeMapService.printMap();
    }
}
