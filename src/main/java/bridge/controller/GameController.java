package bridge.controller;

import bridge.Progress;
import bridge.constant.BridgePattern;
import bridge.constant.Command;
import bridge.constant.GameCondition;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            outputView.startMsg();
            List<String> bridge = generateBridge();
            BridgeGame bridgeGame = new BridgeGame(bridge, new Progress(bridge.size()));
            GameCondition gameCondition = startGame(bridgeGame);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
        }
    }

    public List<String> generateBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private GameCondition startGame(BridgeGame bridgeGame) {
        while (true) {
            GameCondition gameCondition = bridgeGame.move(selectMove());
            outputView.printMap(bridgeGame.exportProgress());

            if (checkCrossFail(bridgeGame, gameCondition)) { return gameCondition; }
        }
    }

    private BridgePattern selectMove() {
        outputView.printSelectMsg();
        return inputView.readMoving();
    }

    private boolean checkCrossFail(BridgeGame bridgeGame, GameCondition gameCondition) {
        if (gameCondition == GameCondition.GOAL) { return true; }
        if (gameCondition == GameCondition.FAILURE) { return checkRetry(bridgeGame); }

        return false;
    }

    private boolean checkRetry(BridgeGame bridgeGame) {
        outputView.printRetryMsg();
        if (inputView.readGameCommand() == Command.DO_QUIT) {
            return true;
        }

        bridgeGame.retry();
        return false;
    }
}


