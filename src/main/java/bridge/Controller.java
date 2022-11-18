package bridge;

public class Controller {
    private final static String ERROR_MESSAGE = "[ERROR]";
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run () {
        BridgeGame bridgeGame = BridgeGame.getInstance();
        String bridgeSize;

        outputView.printGameStart();
        bridgeSize = inputView.readBridgeSize();
        validate(bridgeSize);
    }

    private void validate(String bridgeSize) {
        validateNumber(bridgeSize);
        validateRange(bridgeSize);
    }
    private void validateNumber (String bridgeSize) {
        int number;

        try {
            Integer.parseInt(bridgeSize);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자가 아닙니다.");
        }
    }

    private void validateRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);

        if(number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 3 ~ 20 사이의 수 여야 합니다");
        }
    }
}