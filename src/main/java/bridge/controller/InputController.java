package bridge.controller;

import bridge.view.InputValidation;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getBridgeSize() {
        while (true) {
            try {
                outputView.printEnterSize();
                return checkBridgeSize(inputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private int checkBridgeSize(String sizeInput) throws IllegalArgumentException {
        int size = InputValidation.convertToNumber(sizeInput);
        InputValidation.isValidBridgeSize(size);
        return size;
    }

    public String getMovingDirection() {
        while (true) {
            try {
                outputView.printInputMoving();
                return checkDirection(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private String checkDirection(String directionInput) throws IllegalArgumentException {
        InputValidation.isValidDirection(directionInput);
        return directionInput;
    }

    public String getGameCommand() {
        while (true) {
            try {
                outputView.printInputGameCommand();
                return checkGameCommand(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private String checkGameCommand(String commandInput) throws IllegalArgumentException {
        InputValidation.isValidGameCommand(commandInput);
        return commandInput;
    }
}
