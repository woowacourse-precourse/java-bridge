package bridge;

import static bridge.validation.BridgeValidation.bridgeValidation;
import static bridge.validation.RetryValidation.retryValidation;
import static bridge.validation.StateValidation.stateValidation;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private int bridgeSize;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        bridgeSize = inputBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        runGame(bridgeGame);
        endGame(bridgeGame);
    }

    public void runGame(BridgeGame bridgeGame) {
        do {
            do {
                bridgeGame.addPlayerBridge(inputCommand());
                outputView.printMap(bridgeGame.getPlayerBridge());
                bridgeGame.move();
            } while (bridgeGame.checkCanMove());
        } while (checkRetry(bridgeGame));
    }

    public void endGame(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.getPlayerBridge(), bridgeGame.getIsSuccess());
        outputView.printTotalAttempts(bridgeGame.getCountAttempts());
    }

    public boolean checkRetry(BridgeGame bridgeGame) {
        if (isPlayerArrive(bridgeGame)) {
            return false;
        }
        if(inputRetry().equals("Q")){
            bridgeGame.changeToLoose();
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    public boolean isPlayerArrive(BridgeGame bridgeGame) {
        return bridgeGame.getPlayerBridgePosition() == (bridgeSize) && (bridgeGame.getCurrentIsCorrect().equals("O"));
    }

    private int inputBridgeSize() {
        String input;
        do {
            input = inputView.readBridgeSize();
        } while (!bridgeValidation(input));
        return Integer.parseInt(input);
    }

    private String inputCommand() {
        String input;
        do {
            input = inputView.readMoving();
        } while (!stateValidation(input));
        return input;
    }

    private String inputRetry() {
        String input;
        do {
            input = inputView.readGameCommand();
        } while (!retryValidation(input));
        return input;
    }
}
