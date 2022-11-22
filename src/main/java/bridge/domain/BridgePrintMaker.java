package bridge.domain;

import java.util.List;
import java.util.StringJoiner;

public class BridgePrintMaker {
    StringJoiner upStringJoiner;
    StringJoiner downStringJoiner;
    boolean continueGame;

    public BridgePrintMaker() {
        this.upStringJoiner = new StringJoiner(" | ", "[ ", " ]");
        this.downStringJoiner = new StringJoiner(" | ", "[ ", " ]");
        this.continueGame = true;
    }

    public boolean isContinueGame() {
        return continueGame;
    }

    public void addStepBridge(String userSelectMove, Direction stepDirection) {
        String upMoveResult = Move.getFilterBridgeMove(userSelectMove, Direction.UP, stepDirection);
        String downMoveResult = Move.getFilterBridgeMove(userSelectMove, Direction.DOWN, stepDirection);

        upStringJoiner.add(upMoveResult);
        downStringJoiner.add(downMoveResult);
        updateContinueGame(upMoveResult, downMoveResult);
    }

    public String getBridgePrint() {
        return upStringJoiner.toString() + "\n" + downStringJoiner.toString() + "\n";
    }

    private void updateContinueGame(String upMoveResult, String downMoveResult) {
        if (upMoveResult.equals("X") || downMoveResult.equals("X")) {
            continueGame = false;
        }
    }
}
