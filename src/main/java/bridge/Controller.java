package bridge;

import java.util.List;

public class Controller {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = BridgeGame.getInstance();
    String bridgeSize;

    public void run() {
        outputView.printGameStart();

        do {
            bridgeSize = inputView.readBridgeSize();
        } while (validate(bridgeSize));

        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        System.out.println(bridge);
    }

    private boolean validate(String bridgeSize) {
        try {
            validateNumber(bridgeSize);
            validateRange(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return true;
        }
        return false;
    }

    private void validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw Exceptions.NOT_NUMBER_EXCEPTION.getException();
        }
    }

    private void validateRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);

        if (number < 3 || number > 20) {
            throw Exceptions.OUT_OF_RANGE_EXCEPTION.getException();
        }
    }
}