package bridge;

import java.util.List;

public class Controller {
    private final static String ERROR_MESSAGE = "[ERROR]";
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = BridgeGame.getInstance();
    String bridgeSize;

    public void run() {
        outputView.printGameStart();
        bridgeSize = inputView.readBridgeSize();
        validate(bridgeSize);
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        System.out.println(bridge);
    }

    private void validate(String bridgeSize) {
        validateNumber(bridgeSize);
        validateRange(bridgeSize);
    }

    private void validateNumber(String bridgeSize) {
        int number;

        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(outputView.printNotNumberException());
        }
    }

    private void validateRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);

        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(outputView.printOutOfRangeException());
        }
    }
}