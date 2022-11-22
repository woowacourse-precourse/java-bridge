package bridge;

import bridge.domain.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize == -1) { return; }
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        RetryState retryState = RetryState.RETRY;
        OutputView outputView = new OutputView(bridge);
        while (retryState == RetryState.RETRY) {
            BridgeGameState bridgeGameState = BridgeGameState.NORMAL;
            while (bridgeGameState == BridgeGameState.NORMAL) {
                String moving = inputView.readMoving();
                if (moving == null) { return; }
                bridgeGameState = bridgeGame.move(moving);
                outputView.printMap();
            }
            if (bridgeGameState == BridgeGameState.SUCCESS_AND_END) {
                break;
            }
            String gameCommand = inputView.readGameCommand();
            if (gameCommand == null) { return; }
            retryState = bridgeGame.retry(gameCommand);
        }
        outputView.printResult();
    }
}
