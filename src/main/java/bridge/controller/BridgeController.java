package bridge.controller;

import static bridge.utils.command.GameCommand.RETRY;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    private Bridge bridge;

    public void startGame() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        outputView.printGameStart();
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void playGame() {
        do {
            bridgeGame.move(inputView.readMoving(), bridge.findBlockByIndex(bridgeGame.getMovingCount()));
            outputView.printMap(bridgeGame);
        } while (canMove());
    }

    private boolean canMove() {
        if (bridgeGame.isMovingFail()) {
            return choiceRetryOrQuit();
        }
        return bridgeGame.canMoveMoreBlock(bridge.length());
    }

    private boolean choiceRetryOrQuit() {
        String gameCommand = inputView.readGameCommand();
        if (RETRY.equalCommand(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public void quitGame() {
        outputView.printResult(bridgeGame);
    }
}
