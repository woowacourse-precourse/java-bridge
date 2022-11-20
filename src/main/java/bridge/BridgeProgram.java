package bridge;

import bridge.controller.BridgeGame;
import bridge.dto.MapDto;
import bridge.exception.GameCommandException;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeProgram {

    private BridgeGame bridgeGame;

    private InputView inputView;

    private OutputView outputView;

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
        return !bridgeGame.success() && retry();
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

    private boolean retry() {
        String gameCommand = validateGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private String validateGameCommand() {
        while (true) {
            try {
                String gameCommand = inputView.readGameCommand();
                GameCommandException.validate(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private void quit() {
        outputView.printResult(bridgeGame.getResult());
    }
}
