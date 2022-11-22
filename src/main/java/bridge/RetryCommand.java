package bridge;

import bridge.domain.BridgeGame;

public class RetryCommand {
    public static void move(InputView inputView, BridgeGame bridgeGame) {
        while (bridgeGame.isSuccess() && bridgeGame.moveResults().size() < bridgeGame.bridgeSize()) {
            inputView.chooseSquare();
            String movingCommand = inputView.readMoving().getMovingCommand();
            bridgeGame.move(movingCommand);
            OutputView.printEachMap(bridgeGame.upMap(), bridgeGame.downMap());

            quiteLogic(inputView, bridgeGame);
        }
    }

    private static void retryLogic(InputView inputView, BridgeGame bridgeGame) {
        bridgeGame.retry();
        inputView.chooseSquare();
        OutputView.printEachMap(bridgeGame.upMap(), bridgeGame.downMap());
        move(inputView, bridgeGame);
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

