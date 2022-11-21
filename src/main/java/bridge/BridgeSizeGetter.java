package bridge;

public class BridgeSizeGetter {
    private final InputView inputView;
    private final BridgeSizeValidator validator;

    public BridgeSizeGetter() {
        this.inputView = new InputView();
        this.validator = new BridgeSizeValidator();
    }

    public int getBridgeSize() throws IllegalArgumentException {
        this.inputView.printPromptForBridgeSize();
        String input = inputView.readBridgeSize();

        BridgeSizeValidationCode validationResult = this.validator.validateBridgeSize(input);

        if (validationResult != BridgeSizeValidationCode.VALID) {
            throw new IllegalArgumentException(validationResult.getErrorMessage());
        }

        return Integer.parseInt(input);
    }
}
