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
        RetryCommand.moveLogic(inputView, bridgeGame);

        OutputView outputView = new OutputView();
        outputView.resultGreeting();
        outputView.printResult(bridgeGame.moveResults());
    }

}
