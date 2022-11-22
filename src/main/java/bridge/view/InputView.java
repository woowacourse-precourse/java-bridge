package bridge.view;

import bridge.util.message.SystemMessage;
import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    Validation bridgeValidation, movingValidation, restartQuickValidation;

    public InputView builder() {
        return this;
    }

    public InputView setBridgeValidation(Validation bridgeValidation) {
        this.bridgeValidation = bridgeValidation;
        return this;
    }

    public InputView setMovingValidation(Validation movingValidation) {
        this.movingValidation = movingValidation;
        return this;
    }

    public InputView setRestartQuickValidation(Validation restartQuickValidation) {
        this.restartQuickValidation = restartQuickValidation;
        return this;
    }

    public InputView build() {
        return this;
    }

    public int readBridgeSize() {
        String bridgeSize = validUserInput();
        return Integer.parseInt(bridgeSize);
    }

    private String validUserInput() {
        return validated(bridgeValidation);
    }

    public String readMoving() {
        return validated(movingValidation);
    }

    public String readGameCommand() {
        return validated(restartQuickValidation);
    }

    public String validated(Validation validation) {
        String valid = null;
        try {
            valid = validateUserInput(validation);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage() + System.lineSeparator());
            System.out.print(SystemMessage.OCCUR_EXCEPTION.getMessage() + System.lineSeparator());
            valid = validated(validation);
        }
        return valid;
    }

    private String validateUserInput(Validation validation) {
        String input = userInput();
        validate(input, validation);
        return input;
    }

    private void validate(String input, Validation validation) {
        validation.validate(input);
    }

    private String userInput() {
        return Console.readLine();
    }
}
