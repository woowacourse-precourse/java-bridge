package bridge;

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
}
