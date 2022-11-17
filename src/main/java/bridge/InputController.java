package bridge;

public class InputController {

    public static int getBridgeSize() {
        try {
            String length = InputView.readBridgeSize();
            new BridgeSizeValidator(length);
            return new Converter().toInt(length);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getBridgeSize();
        }
    }

}
