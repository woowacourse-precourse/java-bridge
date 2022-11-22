package bridge.input.getter;

import bridge.console.InputView;
import bridge.input.validator.code.BridgeSizeValidationCode;
import bridge.input.validator.BridgeSizeValidator;

public class BridgeSizeGetter {
    private static final String PROMPT_FOR_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    private static BridgeSizeGetter instance;

    private final InputView inputView;
    private final BridgeSizeValidator validator;

    private BridgeSizeGetter() {
        this.inputView = InputView.getInputView();
        this.validator = new BridgeSizeValidator();
    }

    public static BridgeSizeGetter getBridgeSizeGetter() {
        if (instance == null) {
            instance = new BridgeSizeGetter();
        }
        return instance;
    }

    public int getBridgeSizeFromConsole() throws IllegalArgumentException {
        printPromptForBridgeSize();
        String input = inputView.readBridgeSize();

        BridgeSizeValidationCode validationResult = this.validator.validateBridgeSize(input);

        if (validationResult != BridgeSizeValidationCode.VALID) {
            throw new IllegalArgumentException(validationResult.getErrorMessage());
        }

        return Integer.parseInt(input);
    }

    private void printPromptForBridgeSize() {
        System.out.println(PROMPT_FOR_BRIDGE_SIZE);
    }
}
