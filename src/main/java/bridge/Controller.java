package bridge;

public class Controller {
    private final static String ERROR_MESSAGE = "[ERROR]";
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run () {
        BridgeGame bridgeGame = BridgeGame.getInstance();
        String bridgeNumber;

        outputView.printGameStart();
        bridgeNumber = inputView.readBridgeSize();
        validate(bridgeNumber);
    }

    private void validate(String bridgeNumber) {
        validateNumber(bridgeNumber);
        validateRange(bridgeNumber);
    }
    private void validateNumber (String bridgeNumber) {
        int number;

        try {
            Integer.parseInt(bridgeNumber);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자가 아닙니다.");
        }
    }

    private void validateRange(String bridgeNumber) {
        int number = Integer.parseInt(bridgeNumber);

        if(number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 3 ~ 20 사이의 수 여야 합니다");
        }
    }
}