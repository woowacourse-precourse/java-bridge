package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.constant.Command;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private boolean isGameOver;

    public BridgeGameController() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        isGameOver = false;
    }

    public void doBridgeGame() {
        OutputView.printGameStartMessage();
        initBridgeGame();
        do {
            moveForward(bridgeGame);
            if (bridgeGame.getBridgeGameResult().getIsMoveFail()) {
                isGameOver = handleRestartAndQuit(InputView.readGameCommand(), bridgeGame, bridge);
            }
            isGameOver = isEndOfBridge(bridge, bridgeGame, isGameOver);
        } while (!isGameOver);
    }

    private void initBridgeGame() {
        bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    private void moveForward(BridgeGame bridgeGame) {
        bridgeGame.move(InputView.readMoving());
        OutputView.printMap(bridgeGame.getBridgeGameResult());
    }

    private boolean handleRestartAndQuit(String command, BridgeGame bridgeGame, Bridge bridge) {
        if (Objects.equals(command, Command.RETRY.toString())) {
            bridgeGame.retry(bridge);
            return false;
        }
        OutputView.printResult(bridgeGame);
        return true;
    }

    private boolean isEndOfBridge(Bridge bridge, BridgeGame bridgeGame, boolean isGameOver) {
        if (bridgeGame.getCurrentPosition() == bridge.getSize() - 1) {
            isGameOver = true;
            OutputView.printResult(bridgeGame);
        }
        return isGameOver;
    }
}
