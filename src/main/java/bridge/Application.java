package bridge;

import bridge.view.utils.ConsoleUtils;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeMaker.makeBridge(inputBridgeSize());

    }

    private static int inputBridgeSize() {
        try {
            return ConsoleUtils.inputBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static String inputmoving() {
        try {
            return ConsoleUtils.inputMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputmoving();
        }
    }

    private static String inputGameCommand() {
        try {
            return ConsoleUtils.inputGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommand();
        }
    }
}
