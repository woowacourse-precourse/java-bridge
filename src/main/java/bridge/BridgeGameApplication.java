package bridge;

import bridge.constant.Constants;
import bridge.dto.BridgeGameDto;
import bridge.game.BridgeGame;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class BridgeGameApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartGame();
        makeBridgeGame();
        runApplication();
        printResult();
    }

    private void makeBridgeGame() {
        int length = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(length);
    }

    private void runApplication() {
        while (true) {
            playGame();
            if (bridgeGame.isSuccess() || !isRetry()) {
                break;
            }
            bridgeGame.retry();
        }
    }
    
    private void playGame() {
        while (true) {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame.getBridgeGameDto());
            
            if (!bridgeGame.isContinue()) {
                return;
            }
        }
    }
    
    private boolean isRetry() {
        return inputView.readGameCommand().equals(Constants.RETRY);
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getBridgeGameDto());
    }
}
