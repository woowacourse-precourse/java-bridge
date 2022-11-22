package bridge;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameManager {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameManager(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }
}
