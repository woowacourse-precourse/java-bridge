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

    public void reset() {
        MovedBridge.getInstance().reset();
        gameStatusService.find().addAttemptCount();
    }

    // TODO: 10줄 이내, depth 3이내로 수정 필요
    public String printMap() {
        List<String> bridgeAnswer = bridgeService.find().getBridge();
        List<String> moveBridge = this.find().getBridge();

        StringBuilder upBridge = new StringBuilder(START);
        StringBuilder downBridge = new StringBuilder(START);

        for (int i = 0; i < moveBridge.size() - 1; i++) {
            if (moveBridge.get(i).equals(bridgeAnswer.get(i))) {
                if (moveBridge.get(i).equals(Command.MOVE_UPPER_LETTER.getCommand())) {
                    upBridge.append(CORRECT + DIVISION);
                    downBridge.append(NONE + DIVISION);
                } else if (moveBridge.get(i).equals(Command.MOVE_LOWER_LETTER.getCommand())) {
                    upBridge.append(NONE + DIVISION);
                    downBridge.append(CORRECT + DIVISION);
                }
            }
        }

        int lastIndex = moveBridge.size() - 1;
        if (moveBridge.get(lastIndex).equals(bridgeAnswer.get(lastIndex))) {
            if (moveBridge.get(lastIndex).equals(Command.MOVE_UPPER_LETTER.getCommand())) {
                upBridge.append(CORRECT + END);
                downBridge.append(NONE + END);
            } else if (moveBridge.get(lastIndex).equals(Command.MOVE_LOWER_LETTER.getCommand())) {
                upBridge.append(NONE + END);
                downBridge.append(CORRECT + END);
            }
        } else {
            if (moveBridge.get(lastIndex).equals(Command.MOVE_UPPER_LETTER.getCommand())) {
                upBridge.append(WRONG + END);
                downBridge.append(NONE + END);
            } else if (moveBridge.get(lastIndex).equals(Command.MOVE_LOWER_LETTER.getCommand())) {
                upBridge.append(NONE + END);
                downBridge.append(WRONG + END);
            }
        }
        return upBridge.toString() + NEW_LINE + downBridge.toString() + NEW_LINE;
    }
}
