package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgePlayer;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeManager {

    private final InputView inputView;

    private final OutputView outputView;

    private final BridgeMaker bridgeMaker;

    private final BridgePlayer bridgePlayer;

    private BridgeGame bridgeGame;

    public BridgeManager() {
        inputView = new InputView();
        bridgePlayer = new BridgePlayer();
        outputView = new OutputView(bridgePlayer);
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play() {
        outputView.printStartMessage();
        int bridgeLength = getBridgeLength();
        makeBridge(bridgeLength);
        startGame();
        outputView.printResult();
    }

    private void startGame() {
        while (bridgeGame.isNotGameEnd()) {
            if (isSuccessCrossBridge()) {
                continue;
            }
            if (isRestartGame()) {
                bridgeGame.retry();
                continue;
            }
            break;
        }
    }

    private boolean isSuccessCrossBridge() {
        getPlayerMove();
        bridgeGame.move();
        outputView.printMap(bridgeGame.getRetryStatus());
        bridgeGame.checkRetryGameResult();
        return bridgePlayer.isSuccess();
    }

    private void makeBridge(int bridgeLength) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame = new BridgeGame(bridge, bridgePlayer);
    }

    private int getBridgeLength() {
        outputView.printBridgeLengthMessage();
        return inputView.readBridgeLength();
    }

    private void getPlayerMove() {
        outputView.printPlayerMoveMessage();
        String moveNumber = inputView.readMoving();
        bridgePlayer.saveInputCommand(moveNumber);
    }

    private boolean isRestartGame() {
        outputView.printPlayControlMessage();
        String controlNumber = inputView.readGameCommand();
        bridgePlayer.saveInputCommand(controlNumber);

        return bridgePlayer.isRestart();
    }
}
