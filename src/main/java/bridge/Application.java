package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.greetingGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeSizeParameter bridgeSizeParameter = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeSizeParameter.getBridgeSize());
        RetryCommand.move(inputView, bridgeGame);

        OutputView.resultGreeting();
        OutputView.printMap(bridgeGame.upMap(), bridgeGame.downMap());
        OutputView.printResult(bridgeGame.moveResults());
    }

}
