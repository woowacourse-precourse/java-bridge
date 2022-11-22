package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.GameProgress;
import bridge.domain.GameResult;
import bridge.domain.GameTurn;
import bridge.view.OutputView;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();
        GameTurn gameTurn = GameTurn.MOVE;
        while(gameTurn != GameTurn.QUIT) {
            try {
                gameTurn = controller.playGame(gameTurn);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.toString());
            }
        }
    }
}
