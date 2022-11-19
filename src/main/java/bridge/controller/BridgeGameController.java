package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.exception.InputException;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private int numberOfAttempts = 0;

    public void start() {
        set();
        progress();
        end();
    }

    private void set() {
        OutputView.printStart();
        int size = InputException.validateBridgeSize(InputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }

    private void progress() {
        numberOfAttempts++;

        for(int i=0; i<bridgeGame.getBridgeSize(); i++) {
            bridgeGame.move(i, InputException.validateMovingValue(InputView.readMoving()));
            OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getResult());
            if(!bridgeGame.success()) {
                retry();
                break;
            }
        }
    }

    private void end() {
        OutputView.printResult(bridgeGame.getBridge(), bridgeGame.getResult(), numberOfAttempts);
    }

    private void retry() {
        if(InputException.validateGameCommand(InputView.readGameCommand()).equals("R")) {
            bridgeGame.retry();
            progress();
        }
    }
}
