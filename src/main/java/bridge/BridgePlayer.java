package bridge;

import java.util.List;

import static bridge.constant.BridgeControl.RESTART;
import static bridge.constant.BridgeMove.UP;

public class BridgePlayer {
    private Integer moveBridgeSpace = 0, tryCount = 0;

    private Boolean isSuccess;

    private String lastInputCommand;

    public void checkMove(List<String> bridge) {
        if (bridge.get(moveBridgeSpace).equals(lastInputCommand)) {
            moveCorrectBridge();
            return;
        }
        moveWrongBridge();
    }

    public void moveCorrectBridge() {
        this.moveBridgeSpace++;
        this.tryCount++;
        this.isSuccess = true;
    }

    public void moveWrongBridge() {
        this.tryCount++;
        this.isSuccess = false;
    }

    public boolean checkMoveSuccess() {
        return isSuccess;
    }

    public int getCurrentBridgeSpace() {
        return moveBridgeSpace;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void saveInputCommand(String moveNumber) {
        this.lastInputCommand = moveNumber;
    }

    public boolean isMoveUp() {
        return lastInputCommand.equals(UP.getIdentifier());
    }

    public boolean isRestart() {
        return lastInputCommand.equals(RESTART.getIdentifier());
    }
}
