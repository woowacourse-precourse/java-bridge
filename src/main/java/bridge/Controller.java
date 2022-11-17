package bridge;

import java.util.List;

public class Controller {
    private final BridgeGame bridgeGame;

    Controller() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()));
    }

    private int getBridgeSize() {
        InputView inputView = new InputView();
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private String getString(Integer which) {
        InputView inputView = new InputView();
        while (true) {
            try {
                return inputView.readString(which);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private boolean stepGame() {
        String input = getString(InputView.MOV);
        return bridgeGame.move(input);
    }
}
