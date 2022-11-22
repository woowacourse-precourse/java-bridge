package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.greetingGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeSize);
        RetryFrame.move(inputView, bridgeGame);

        OutputView.resultGreeting();
        OutputView.printMap(bridgeGame.upMap(), bridgeGame.downMap());
        OutputView.printResult(bridgeGame.moveResults());
    }

}
