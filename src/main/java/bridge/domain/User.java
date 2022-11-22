package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;
import java.util.Objects;

import static bridge.util.Constants.InputViewConstants.QUIT;
import static bridge.util.Constants.InputViewConstants.RESTART;

public class User {

    private static HashMap<Integer, String> pastResult;
    public int currentBlock;
    private boolean isGameClear = true;
    private boolean isRestartGame = true;
    private static int retryCount = 1;

    public User() {
        pastResult = new HashMap<>();
    }

    public boolean changeStatusIsFailed(boolean result) {
        if (!result) {
            isGameClear = false;
            isRestartGame = false;
            return true;
        }
        isGameClear = true;
        isRestartGame = true;
        return false;
    }

    public void addBridgeInfo(int step, String movingBlock) {
        pastResult.put(step, movingBlock);
    }

    public HashMap<Integer, String> getPastResult() {
        return pastResult;
    }

    public boolean isRestartGame() {
        return isRestartGame;
    }

    public boolean ifUserInputQStopGameOrElseRestart(String restartGameWhether) {
        if (Objects.equals(restartGameWhether, RESTART.getMessage())) {
            retryCount++;
            return true;
        }

        if (Objects.equals(restartGameWhether, QUIT.getMessage())) {
            isRestartGame = true;
        }
        return false;
    }

    public void printResult() {
        OutputView.printResult(isGameClear, retryCount);
    }

    public String readGameCommand() {
        return InputView.readGameCommand();
    }
}
