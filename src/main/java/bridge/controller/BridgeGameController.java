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
