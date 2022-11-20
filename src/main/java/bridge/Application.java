package bridge;

import java.util.List;

public class Application {

    private static int bridgeSize;
    private static List<String> bridge;
    private static InputView inputView = new InputView();

    public static void main(String[] args) {
        start();
        enterBridgeSize();
        makeBridge();
    }

    public static void start() {
        System.out.println(GameMessage.START.getMessage());
    }

    public static void enterBridgeSize() {
        try {
            String userBridgeSize = inputView.readBridgeSize();
            Validator.validateNumber(userBridgeSize);
            int tempBridgeSize = Converter.convertToNumber(userBridgeSize);
            Validator.validateRange(tempBridgeSize);
            bridgeSize = tempBridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterBridgeSize();
        }
    }

    public static void makeBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
