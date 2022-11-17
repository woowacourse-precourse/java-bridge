package bridge;

import java.util.List;

public class Controller {
    private final BridgeGame bridgeGame;
    private final OutputView outputView;

    Controller() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()));
        outputView = new OutputView();
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
        String move = getString(InputView.MOV);
        if (bridgeGame.move(move)) {
            outputView.printMap(move, true);
            return true;
        }
        outputView.printMap(move, false);
        if (bridgeGame.retry(getString(InputView.CMD))) {
            outputView.retry();
            return true;
        }
        return false;
    }

    public void startGame() {
        while (true)
            if (bridgeGame.ifEnd() || !stepGame())
                break;
        
        outputView.printResult();
    }


}
