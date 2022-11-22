package bridge;

import bridge.domain.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(inputView.readBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        RetryState retryState = RetryState.RETRY;
        OutputView outputView = new OutputView(bridge);
        while (retryState == RetryState.RETRY) {
            BridgeGameState bridgeGameState = BridgeGameState.NORMAL;
            while (bridgeGameState == BridgeGameState.NORMAL) {
                bridgeGameState = bridgeGame.move(inputView.readMoving());
                outputView.printMap();
            }
            if (bridgeGameState == BridgeGameState.SUCCESS_AND_END) {
                break;
            }
            retryState = bridgeGame.retry(inputView);
        }
        outputView.printResult();
    }
}
