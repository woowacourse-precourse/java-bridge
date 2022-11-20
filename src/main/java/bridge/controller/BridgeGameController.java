package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.command.GameCommand;
import bridge.exception.InputException;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private int numberOfAttempts = 0;

    public void start() {
        OutputView.printStart();
        set();
        progress();
        end();
    }

    private void set() {
        try {
            int size = getSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            set();
        }
    }

    private int getSize() {
        int size = InputException.convertToNumber(InputView.readBridgeSize());
        InputException.validateBridgeSize(size);
        return size;
    }

    private void progress() {
        numberOfAttempts++;
        for(int i=0; i<bridgeGame.getBridgeSize(); i++) {
            moveAndPrint(i);
            if(!bridgeGame.success()) {
                retry();
                break;
            }
        }
    }

    private void moveAndPrint(int index) {
        bridgeGame.move(index, InputException.validateMovingValue(InputView.readMoving()));
        OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getResult());
    }

    private void end() {
        OutputView.printResult(bridgeGame, numberOfAttempts);
    }

    private void retry() {
        if(InputException.validateGameCommand(InputView.readGameCommand()).equals(GameCommand.Restart.get())) {
            bridgeGame.retry();
            progress();
        }
    }
}
