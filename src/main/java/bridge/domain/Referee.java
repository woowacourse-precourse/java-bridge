package bridge.domain;

import bridge.ui.Constant;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Referee {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void start() {
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        int gameResult = runningGame(bridgeGame);
        while (gameResult == Constant.GAME_RESTART) {
            bridgeGame.retry();
            gameResult = runningGame(bridgeGame);
        }
        outputView.printResult(gameResult, bridgeGame);
    }

    private int runningGame(BridgeGame bridgeGame) {
        do {
            String inputGoingBlock = inputView.readMoving();
            if (!bridgeGame.move(inputGoingBlock)){
                outputView.printMap(bridgeGame, Constant.TOKEN_FAIL);
                return inputView.readGameCommand();
            }
            outputView.printMap(bridgeGame, Constant.TOKEN_CLEAR);
        } while (!bridgeGame.isClear());
        return Constant.GAME_CLEAR;
    }
}
