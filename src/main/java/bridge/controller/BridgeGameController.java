package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        try {
            BridgeGame bridgeGame = createGame();
            createGameProgress(bridgeGame);
            outputView.printResult(bridgeGame.toString(), !bridgeGame.isFail(), bridgeGame.getTryNumber());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private void createGameProgress(BridgeGame bridgeGame) {
        boolean moveFlag = true;
        while (moveFlag) {
            moveFlag = createMove(bridgeGame);
            if (bridgeGame.isGameEnd()) {
                break;
            }
            moveFlag = checkRestart(bridgeGame, moveFlag);
        }
    }

    private boolean createMove(BridgeGame bridgeGame) {
        boolean moveFlag;
        outputView.printChooseMove();
        String move = inputView.readMoving();
        moveFlag = bridgeGame.move(move);
        outputView.printMap(bridgeGame.toString());
        return moveFlag;
    }

    private boolean checkRestart(BridgeGame bridgeGame, boolean moveFlag) {
        if (!moveFlag) {
            outputView.printRestart();
            String restart = inputView.readGameCommand();
            if (bridgeGame.retry(restart)) {
                moveFlag = true;
            }
        }
        return moveFlag;
    }

    private BridgeGame createGame() {
        outputView.printStartMsg();
        outputView.printRequestLenOfBridge();
        int size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new BridgeGame(bridge);
    }
}
