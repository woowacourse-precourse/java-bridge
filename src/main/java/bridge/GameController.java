package bridge;

import java.util.List;

public class GameController {
    BridgeGame bridgeGame;
    OutputView outputView = new OutputView();
    private boolean doesPlayerWantRetrial = true;
    private boolean isMovingAvailable;
    public GameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void runGame() {
        do {
            executeMoving();
            executeRetrial(isMovingAvailable);
        } while (decideToKeepPlaying());
    }

    private void executeMoving() {
        InputView inputView = new InputView();
        String playerMoving = inputView.readMoving();
        this.isMovingAvailable = bridgeGame.checkMoveIsAvailable(playerMoving);

        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayerLocation(), isMovingAvailable);
        bridgeGame.move(isMovingAvailable);
    }

    private void executeRetrial(boolean isMovingAvailable) {
        if (!isMovingAvailable) {
            InputView inputView = new InputView();
            String gameCommand = inputView.readGameCommand();
            GameCommandJudge gameCommandJudge = new GameCommandJudge();

            doesPlayerWantRetrial = gameCommandJudge.checkPlayerWantsRetrial(gameCommand);
            bridgeGame.retry(doesPlayerWantRetrial);
        }
    }

    private boolean decideToKeepPlaying() {
        if (doesPlayerWantRetrial && bridgeGame.getPlayerLocation() < bridgeGame.getBridge().size() - 1) {
            return true;
        }
        return false;
    }

    public boolean getIsMovingAvailable() {
        return this.isMovingAvailable;
    }
}
