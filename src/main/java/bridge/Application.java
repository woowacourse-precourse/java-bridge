package bridge;

import bridge.domain.*;
import bridge.state.BridgeGameState;
import bridge.state.ErrorState;
import bridge.state.RetryState;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize == -1) { return; }
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView(bridgeGame);
        if (proceed(bridgeGame, inputView, outputView) == ErrorState.ERROR) { return; }
        outputView.printResult();
    }

    private static ErrorState proceed(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        while (bridgeGame.getRetryState() == RetryState.RETRY || bridgeGame.getRetryState() == RetryState.START) {
            bridgeGame.increaseNumOfGamePlayed();
            if (subProceed(bridgeGame, inputView, outputView) == ErrorState.ERROR) { return ErrorState.ERROR; }
            if (bridgeGame.getBridgeGameState() == BridgeGameState.SUCCESS_AND_END) { return ErrorState.NONE; }
            String gameCommand = inputView.readGameCommand();
            if (gameCommand == null) { return ErrorState.ERROR; }
            bridgeGame.retry(gameCommand);
        }
        return ErrorState.NONE;
    }

    private static ErrorState subProceed(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        while (bridgeGame.getBridgeGameState() == BridgeGameState.NORMAL) {
            String moving = inputView.readMoving();
            if (moving == null) {
                return ErrorState.ERROR;
            }
            bridgeGame.move(moving);
            outputView.printMap();
        }
        return ErrorState.NONE;
    }
}
