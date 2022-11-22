package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.MoveResults;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.greetingGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeSizeParameter bridgeSizeParameter = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeSizeParameter.getBridgeSize());
        RetryCommand.moveLogic(inputView, bridgeGame);

        MoveResults moveResults = bridgeGame.moveResults();
        OutputView outputView = new OutputView();
        OutputView.resultGreeting();
        outputView.printMap(bridgeGame.upMap(), bridgeGame.downMap());
        outputView.printResult(moveResults);
    }

}
