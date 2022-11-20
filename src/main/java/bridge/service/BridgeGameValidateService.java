package bridge.service;

import bridge.validator.GameRetryOrEndCommandValidator;
import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.InputNextStepValidator;

public class BridgeGameValidateService {

    private final InputBridgeSizeValidator inputBridgeSizeValidator = new InputBridgeSizeValidator();
    private final InputNextStepValidator inputNextStepValidator = new InputNextStepValidator();
    private final GameRetryOrEndCommandValidator gameRetryOrEndCommandValidator = new GameRetryOrEndCommandValidator();

    public void validateInputBridgeSize(String inputBridgeSize) {
        inputBridgeSizeValidator.validate(inputBridgeSize);
    }

    public void validateInputNextStep(String inputNextStep) {
        inputNextStepValidator.validate(inputNextStep);
    }

    public void validateGameRetryOrEndCommand(String gameRetryOrEndCommand) {
        gameRetryOrEndCommandValidator.validate(gameRetryOrEndCommand);
    }
}
