package bridge.domain;

import java.util.List;

import static bridge.constant.BridgeControl.RESTART;
import static bridge.constant.BridgeMove.UP;

public class BridgePlayer {

    private Integer moveBridgeSpace = 0, tryCount = 1;

    private Boolean isSuccess;

    private String lastInputCommand;

    public void checkMove(List<String> bridge) {
        if (bridge.get(moveBridgeSpace).equals(lastInputCommand)) {
            moveCorrectBridge();
            return;
        }
        moveWrongBridge();
    }

    private void moveCorrectBridge() {
        this.moveBridgeSpace++;
        this.isSuccess = true;
    }

    private void moveWrongBridge() {
        this.isSuccess = false;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCurrentBridgeSpace() {
        return moveBridgeSpace;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void saveInputCommand(String inputCommand) {
        this.lastInputCommand = inputCommand;
    }

    public boolean isMoveUp() {
        return lastInputCommand.equals(UP.getIdentifier());
    }

    public boolean isRestart() {
        return lastInputCommand.equals(RESTART.getIdentifier());
    }

    public void addTryCount() {
        this.tryCount += 1;
    }
}
