package bridge;

public class BridgeSizeGetter {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeSizeValidator validator;

    public BridgeSizeGetter() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validator = new BridgeSizeValidator();
    }

    public int getBridgeSizeFromConsole() throws IllegalArgumentException {
        this.outputView.printPromptForBridgeSize();
        String input = inputView.readBridgeSize();

        BridgeSizeValidationCode validationResult = this.validator.validateBridgeSize(input);

        if (validationResult != BridgeSizeValidationCode.VALID) {
            throw new IllegalArgumentException(validationResult.getErrorMessage());
        }

        return Integer.parseInt(input);
    }
}
