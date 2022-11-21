package bridge.controller;

import static bridge.utils.command.GameCommand.QUIT;
import static bridge.utils.command.GameCommand.RETRY;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    private Bridge bridge;
    private boolean isMovingSuccess = false;

    public void startGame() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        outputView.printGameStart();
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void playGame() {
        for (int bridgeIndex = 0; bridgeIndex < bridge.length(); bridgeIndex++) {
            isMovingSuccess = bridgeGame.move(inputView.readMoving(), bridge.findBlockByIndex(bridgeIndex));
            outputView.printMap(bridgeGame);
            bridgeIndex = checkMovingFail(bridgeIndex);
        }
    }

    private int checkMovingFail(int bridgeIndex) {
        if (!isMovingSuccess) {
            bridgeIndex = choiceRetryOrQuit(bridgeIndex);
        }
        return bridgeIndex;
    }

    private int choiceRetryOrQuit(int bridgeIndex) {
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, RETRY.getCommand())) {
            bridgeGame.retry();
            bridgeIndex = -1;
        }
        if (Objects.equals(gameCommand, QUIT.getCommand())) {
            bridgeIndex = bridge.length();
        }
        return bridgeIndex;
    }

    public void quitGame() {
        outputView.printResult(bridgeGame);
    }
}
