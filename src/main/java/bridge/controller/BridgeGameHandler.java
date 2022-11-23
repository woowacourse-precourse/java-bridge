package bridge.controller;

import bridge.core.BridgeGame;
import bridge.type.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameHandler {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public BridgeGame initGame() {
        BridgeGame bridgeGame;
        do {
            bridgeGame = BridgeGame.initBridgeGame(inputView.readBridgeLength());
        } while (bridgeGame == null);
        return bridgeGame;
    }

    public ProcessCondition executeGame(ProcessCondition processCondition, BridgeGame bridgeGame) {
        if (processCondition.equals(GameStatus.START) || processCondition.equals(PassCondition.PASS)) {
            return executePassCondition(bridgeGame);
        }
        if (processCondition.equals(PassCondition.FAIL)) {
            return executeFailCondition(bridgeGame);
        }
        return null;
    }

    public ProcessCondition executePassCondition(BridgeGame bridgeGame) {
        ProcessCondition passCondition;
        do {
            passCondition = bridgeGame.move(inputView.readSelectedBridgeBlock());
        } while (passCondition == null);
        outputView.printMap(passCondition, bridgeGame);
        FinishCondition finishCondition = bridgeGame.checkWhetherFinished(passCondition);
        if (finishCondition.equals(FinishCondition.FINISHED)) return bridgeGame.quit(FinishCondition.FINISHED);
        return executeGame(passCondition, bridgeGame);
    }

    public ProcessCondition executeFailCondition(BridgeGame bridgeGame) {
        ProcessCondition selectGameProcess;
        do {
            selectGameProcess = bridgeGame.selectRetryOrQuit(inputView.readGameCommand());
        } while (selectGameProcess == null);
        if (selectGameProcess.equals(GameStatus.RESTART)) return executeGame(bridgeGame.retry(), bridgeGame);
        return bridgeGame.quit(FinishCondition.NOT_FINISHED);
    }
}
