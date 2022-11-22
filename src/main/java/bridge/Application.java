package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.GameProgress;
import bridge.domain.GameResult;
import bridge.view.OutputView;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();

        try {
            controller.playGame();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.toString());
        }
    }
}
