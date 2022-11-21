package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgePlay {

    private final InputView inputView;

    private final OutputView outputView;

    private final BridgeMaker bridgeMaker;

    private BridgeGame bridgeGame;

    public BridgePlay() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play() {
        outputView.printStartMessage();
        int bridgeLength = getBridgeLength();
        makeBridge(bridgeLength);
    }

    private void makeBridge(int bridgeLength) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame = new BridgeGame(bridge);
    }

    private String getPlayControlNumber() {
        outputView.printPlayControlMessage();
        return inputView.readGameCommand();
    }

    private int getBridgeLength() {
        outputView.printBridgeLengthMessage();
        return inputView.readBridgeLength();
    }

    private String getPlayerMove() {
        outputView.printPlayerMoveMessage();
        return inputView.readMoving();
    }
}
