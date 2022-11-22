package bridge.domain;

import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;

    public GameController(InputView inputview, OutputView outputview, BridgeMaker bridgeMaker) {
        this.inputView = inputview;
        this.outputView = outputview;
        this.bridge = initializeGame(bridgeMaker);
    }

    private Bridge initializeGame(BridgeMaker bridgeMaker) {
        outputView.printGameStart();
        try {
            return createBridge(bridgeMaker);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createBridge(bridgeMaker);
        }
    }

    private int getBridgeLength() {
        try {
            outputView.printGetBridgeLength();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBridgeLength();
        }
    }

    private Bridge createBridge(BridgeMaker bridgeMaker) {
        int bridgeLength = getBridgeLength();
        try {
            return new Bridge(bridgeMaker.makeBridge(bridgeLength));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createBridge(bridgeMaker);
        }
    }

}
