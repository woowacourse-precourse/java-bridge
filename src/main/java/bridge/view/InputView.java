package bridge.view;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final Validator validator;
    private final OutputView outputView;

    public InputView(Validator validator, OutputView outputView) {
        this.validator = validator;
        this.outputView = outputView;
    }

    public int readBridgeSize() {
        outputView.printMessage(Messages.VIEW_BRIDGE_SIZE);
        String userInput = "";

        userInput = readBridgeSizeUntilCollectFormat(userInput);

        return Integer.parseInt(userInput);
    }

    public String readBridgeSizeUntilCollectFormat(String userInput) {
        while(true) {
            try {
                userInput = readInput();
                validator.validateBridgeSize(userInput);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
        return userInput;
    }

    public String readMoving() {
        outputView.printMessage(Messages.VIEW_SELECT_UP_DOWN);
        String userInput = "";

        userInput = readMoveUntilCollectFormat(userInput);

        return userInput;
    }

    public String readMoveUntilCollectFormat(String userInput) {
        while(true) {
            try {
                userInput = readInput();
                validator.validateMove(userInput);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
        return userInput;
    }


    public String readGameCommand() {
        outputView.printMessage(Messages.VIEW_RETRY);
        String userInput = "";

        userInput = readGameCommandUntilCollectFormat(userInput);

        return userInput;
    }

    public String readGameCommandUntilCollectFormat(String userInput) {
        while(true) {
            try {
                userInput = readInput();
                validator.validateGameCommand(userInput);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
        return userInput;
    }

    public String readInput() {
        String userInput = Console.readLine();
        return userInput;
    }
}
