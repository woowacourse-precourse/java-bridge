package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static int bridgeSize;
    private static List<String> bridge;
    private static char moving;
    private static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        start();
        enterBridgeSize();
        makeBridge();
        enterMoving();
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


    public static void enterMoving() {
        try {
            String userMoving = inputView.readMoving();
            Validator.validateLength(userMoving);
            char tempMoving = Converter.convertToLetter(userMoving);
            Validator.validateMoving(tempMoving);
            moving = tempMoving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterMoving();
        }
    }
}
