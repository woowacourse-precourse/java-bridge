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

    // true if valid move or retry, false if terminate
    private boolean stepGame() {
        OutputView outputView = new OutputView();
        String move = getString(InputView.MOV);
        if (bridgeGame.move(move)) {
            outputView.printMap(move, true);
            return true;
        }
        outputView.printMap(move, false);
        return bridgeGame.retry(getString(InputView.CMD));
    }


}
