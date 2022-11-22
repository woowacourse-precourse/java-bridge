package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgePlay {

    private final InputView inputView;

    private final OutputView outputView;

    private final BridgeMaker bridgeMaker;

    private final BridgePlayer bridgePlayer;

    private BridgeGame bridgeGame;

    public BridgePlay() {
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
        while(bridgeGame.isNotGameEnd()) {
            getPlayerMove();
            crossBridge();
            if(bridgePlayer.checkMoveSuccess()) {
                bridgeGame.retry(false);
                continue;
            }
            getPlayControlNumber();
            if (bridgePlayer.isRestart()) {
                bridgeGame.retry(true);
                continue;
            }
            break;
        }
    }

    private void crossBridge() {
        outputView.printPlayerMoveMessage();
        bridgeGame.move();
        outputView.printMap(bridgeGame.getRetryStatus());
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

    private void getPlayControlNumber() {
        outputView.printPlayControlMessage();
        String controlNumber = inputView.readGameCommand();
        bridgePlayer.saveInputCommand(controlNumber);
    }
}
