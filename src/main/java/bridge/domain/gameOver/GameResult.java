package bridge.domain.gameOver;

import bridge.view.OutputView;

import java.util.List;

public class GameResult {
    private static final int ONE_INDEX = 1;
    private static final String MOVE_FAIL = "X";

    public static void takeResult(List<String> currentBridge, List<String> originalBridge, int gameAttemptsCount) {
        OutputView outputView = new OutputView();
        outputView.printResult(currentBridge);

        boolean successOrFail = checkSuccessOrFailOfGameResult(currentBridge, originalBridge);
        outputView.printGameSuccessOrFail(successOrFail);
    }

    public static boolean checkSuccessOrFailOfGameResult(List<String> currentBridge, List<String> originalBridge) {
        if (currentBridge.size() != originalBridge.size()) {
            return false;
        }

        int lastLocation = currentBridge.size() - ONE_INDEX;
        if (currentBridge.get(lastLocation).contains(MOVE_FAIL)) {
            return false;
        }
        return true;
    }
}
