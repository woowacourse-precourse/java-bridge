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
    }

    private void makeBridgeGame() {
        int length = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(length);
    }

    private void runApplication() {
        BridgeGameDto result;
        while (true) {
            result = playGame();

            if (bridgeGame.isSuccess() || !isRetry()) {
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(result);
    }
    
    private BridgeGameDto playGame() {
        while (true) {
            String moving = inputView.readMoving();
            BridgeGameDto currentBridgeDto = bridgeGame.move(moving);
            outputView.printMap(currentBridgeDto);
            
            if (!bridgeGame.isContinue()) {
                return currentBridgeDto;
            }
        }
    }
    
    private boolean isRetry() {
        return inputView.readGameCommand().equals(Constants.RETRY);
    }
}
