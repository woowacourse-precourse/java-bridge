package bridge;

public class InputController {

    public static int getBridgeSize() {
        try {
            String size = InputView.readBridgeSize();
            new BridgeSizeValidator(size);
            return new Converter().toInt(size);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getBridgeSize();
        }
    }

}
