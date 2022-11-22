package bridge;

import java.util.List;

public class GameController {
    BridgeGame bridgeGame;
    OutputView outputView = new OutputView();
    boolean doesPlayerWantRetrial = true;
    public GameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void executeMoving() {
        InputView inputView = new InputView();
        String playerMoving = inputView.readMoving();
        boolean doesPlayerSucceedMoving = bridgeGame.checkSuccessOfMoving(playerMoving);

        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayerLocation(), doesPlayerSucceedMoving);
        bridgeGame.move(playerMoving);
        executeRetrial(doesPlayerSucceedMoving);
    }

    public void executeRetrial(boolean doesPlayerSucceedMoving) {
        if (!doesPlayerSucceedMoving) {
            InputView inputView = new InputView();
            String gameCommand = inputView.readGameCommand();

            bridgeGame.retry(gameCommand);
            this.doesPlayerWantRetrial = bridgeGame.checkPlayerWantsRetrial(gameCommand);
        }
    }
}
