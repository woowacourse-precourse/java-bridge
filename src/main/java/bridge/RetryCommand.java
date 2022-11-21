package bridge;

import bridge.domain.BridgeGame;

public class RetryCommand {
    public static void moveLogic(InputView inputView, BridgeGame bridgeGame) {
        while (bridgeGame.isSuccess() && bridgeGame.moveResults().size() < bridgeGame.bridgeSize()) {
            inputView.chooseSquare();
            bridgeGame.move(inputView.readMoving());
            OutputView.printEachMap(bridgeGame.moveResults());
            quiteLogic(inputView, bridgeGame);
        }
    }

    private static void retryLogic(InputView inputView, BridgeGame bridgeGame) {
        bridgeGame.moveResults().removeFailure();
        inputView.chooseSquare();
        OutputView.printEachMap(bridgeGame.moveResults());
        moveLogic(inputView, bridgeGame);
    }

    private static void quiteLogic(InputView inputView, BridgeGame bridgeGame) {
        if (!bridgeGame.isSuccess() && inputView.readGameCommand().quiet()) {
            return;
        }
        if (!bridgeGame.isSuccess()) {
            retryLogic(inputView, bridgeGame);
        }
    }

}

