package bridge.domain.gameOver;

import bridge.view.OutputView;

import java.util.List;

public class GameResult {
    public static void takeResult(List<String> currentBridge) {
        OutputView outputView = new OutputView();

        outputView.printResult(currentBridge);
    }
}
