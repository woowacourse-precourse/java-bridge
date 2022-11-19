package bridge;

import java.util.List;

public class BridgeGame {
    private final InputView inputView;
    private final BridgeLengthValidator bridgeLengthValidator;
    private final BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.inputView = new InputView();
        this.bridgeLengthValidator = new BridgeLengthValidator();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void runGame() {
        notifyGameStart();
        System.out.println();
        List<String> bridge = this.bridgeMaker.makeBridge(getBridgeLength());
        System.out.println();
    }

    public void move() {
    }

    public void retry() {
    }

    public void notifyGameStart() {
        this.inputView.printGameStart();
    }

    public int getBridgeLength() throws IllegalArgumentException {
        this.inputView.printPromptForBridgeLength();
        String input = inputView.readBridgeLength();

        BridgeLengthValidationCode validationResult = this.bridgeLengthValidator.validateBridgeLength(input);

        if (validationResult != BridgeLengthValidationCode.VALID) {
            throw new IllegalArgumentException(validationResult.getErrorMessage());
        }

        return Integer.parseInt(input);
    }
}
