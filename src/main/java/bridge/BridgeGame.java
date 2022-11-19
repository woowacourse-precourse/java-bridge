package bridge;

import java.util.List;

public class BridgeGame {
    private static BridgeGame bridgeGame;

    private final InputView inputView;
    private final BridgeSizeValidator bridgeSizeValidator;
    private final BridgeMaker bridgeMaker;

    private BridgeGame() {
        this.inputView = new InputView();
        this.bridgeSizeValidator = new BridgeSizeValidator();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public static BridgeGame getBridgeGame() {
        if (bridgeGame == null) {
            bridgeGame = new BridgeGame();
        }
        return bridgeGame;
    }

    public void runGame() {
        notifyGameStart();
        System.out.println();
        List<String> bridge = this.bridgeMaker.makeBridge(getBridgeSize());
        System.out.println();
    }

    public void move() {
    }

    public void retry() {
    }

    public void notifyGameStart() {
        this.inputView.printGameStart();
    }

    public int getBridgeSize() throws IllegalArgumentException {
        this.inputView.printPromptForBridgeSize();
        String input = inputView.readBridgeSize();

        BridgeSizeValidationCode validationResult = this.bridgeSizeValidator.validateBridgeSize(input);

        if (validationResult != BridgeSizeValidationCode.VALID) {
            throw new IllegalArgumentException(validationResult.getErrorMessage());
        }

        return Integer.parseInt(input);
    }
}
