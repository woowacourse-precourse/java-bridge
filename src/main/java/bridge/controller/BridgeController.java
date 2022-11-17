package bridge.controller;

import bridge.BridgeGame;
import bridge.dto.CurrentPositionDto;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private InputView inputView;

    private OutputView outputView;

    private BridgeGame bridgeGame;

    private Validator validator;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
        this.validator = validator;
    }

    public void run() {
        printStartMessage();
        makeBridge();
        while (true) {
            movePlayer();
        }

    }

    private void movePlayer() {
        String direction = getDirection();
        bridgeGame.move(direction);
        CurrentPositionDto currentPosition = bridgeGame.getCurrentPosition();
        outputView.printMap(currentPosition);
    }

    private void makeBridge() {
        int bridgeSize = getBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }

    private String getDirection() {
        while (true) {
            String input = inputView.readMoving();
            try {
                validator.checkMoving(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return input;
        }
    }

    private int getBridgeSize() {
        while (true) {
            String input = inputView.readBridgeSize();
            try {
                validator.checkBridgeSize(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return Integer.parseInt(input);
        }
    }

    private void printStartMessage() {
        outputView.printGreetingMessage();
    }
}
