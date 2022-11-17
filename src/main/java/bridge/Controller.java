package bridge;

import java.util.List;

public class Controller {
    private final BridgeGame bridgeGame;
    private final OutputView outputView = new OutputView();;
    private Integer trial = 1;

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
        String move = getString(InputView.MOV);
        if (bridgeGame.move(move)) {
            outputView.updateAndPrint(move, true);
            return true;
        }
        outputView.updateAndPrint(move, false);
        if (bridgeGame.retry(getString(InputView.CMD))) {
            trial++;
            outputView.retry();
            return true;
        }
        return false;
    }

    public void startGame() {
        while (true) {
            if (bridgeGame.ifEnd()) {
                outputView.printResult(true, trial);
                break;
            }
            if (!stepGame()) {
                outputView.printResult(false, trial);
                break;
            }
        }
    }


}
