package bridge;

public class Application {

    private static int bridgeSize;

    public static void main(String[] args) {
        start();
        enterBridgeSize();
    }

    public static void start() {
        System.out.println(GameMessage.START.getMessage());
    }

    public static void enterBridgeSize() {
        InputView inputView = new InputView();
        try {
            String userInput = inputView.readBridgeSize();
            Validator.validateNumber(userInput);
            int tempBridgeSize = Converter.convertToNumber(userInput);
            Validator.validateRange(tempBridgeSize);
            bridgeSize = tempBridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterBridgeSize();
        }
    }
}
