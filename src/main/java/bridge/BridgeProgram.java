package bridge;

import bridge.controller.BridgeGame;
import bridge.dto.MapDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeProgram {

    private final BridgeGame bridgeGame;

    private final InputView inputView;

    private final OutputView outputView;

    public BridgeProgram() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        outputView.printStart();
        make();
        do {
            move();
        } while (canRetry());
        quit();
    }

    private boolean canRetry() {
        return !bridgeGame.success() && checkGameCommand();
    }

    private void make() {
        while (true) {
            try {
                bridgeGame.make(inputView.readBridgeSize());
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private void move() {
        do {
            MapDto mapDto = getMap();
            outputView.printMap(mapDto);
        } while (bridgeGame.canMove());
    }

    private MapDto getMap() {
        while (true) {
            try {
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private boolean checkGameCommand() {
        while (true) {
            try {
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private void quit() {
        outputView.printResult(bridgeGame.getResult());
    }
}
