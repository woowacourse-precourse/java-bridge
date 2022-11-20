package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMoveLog;
import bridge.model.BridgeType;
import bridge.model.ContinueType;
import bridge.model.GameStatus;
import bridge.util.ExceptionHandle;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();

    private final InputView inputView = new InputView();

    private final ExceptionHandle exceptionHandle = new ExceptionHandle(outputView);

    public void startGame() {
        outputView.printGameStart();
        List<String> bridge = createBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge, new BridgeMoveLog(bridge.size()));
        GameStatus resultStatus = play(bridgeGame);
        outputView.printResult(bridgeGame, resultStatus);
    }

    private List<String> createBridge() {
        return exceptionHandle.getCorrectInput(() -> {
            outputView.printRequestBridgeLength();
            int bridgeSize = inputView.readBridgeSize();
            return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        });
    }

    private GameStatus play(BridgeGame bridgeGame) {

        while (true) {
            GameStatus gameStatus = bridgeGame.move(choiceBridge());
            outputView.printMap(bridgeGame.getBridgeMoveLog());

            if ((gameStatus == GameStatus.FAIL && isGiveUp(bridgeGame)) || gameStatus == GameStatus.SUCCESS) {
                return gameStatus;
            }
        }
    }

    private BridgeType choiceBridge() {
        return exceptionHandle.getCorrectInput(() -> {
            outputView.printRequestMoveBridge();
            return inputView.readMoving();
        });
    }

    private boolean isGiveUp(BridgeGame bridgeGame) {
        return exceptionHandle.getCorrectInput(() -> {
            outputView.printWantToContinue();

            if (inputView.readGameCommand() == ContinueType.QUIT) {
                return true;
            }

            bridgeGame.retry();
            return false;
        });
    }

}
