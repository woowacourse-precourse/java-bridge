package bridge;

import java.util.List;

public class Controller {
    private final BridgeGame bridgeGame;

    Controller() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(retrieveBridgeSize()));
    }

    int retrieveBridgeSize() {
        InputView inputView = new InputView();
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    void startGame() {
        while (true) {

        }
    }
}
