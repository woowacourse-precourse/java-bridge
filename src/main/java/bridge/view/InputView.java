package bridge.view;

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
        String bridgeSize = validatedUserInput(bridgeValidation);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        return validatedUserInput(movingValidation);
    }

    public String readGameCommand() {
        return validatedUserInput(restartQuickValidation);
    }

    private String validatedUserInput(Validation validation) {
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
