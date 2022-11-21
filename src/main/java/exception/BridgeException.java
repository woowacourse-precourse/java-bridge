package exception;

import message.ErrorMessage;
import view.OutputView;

public class BridgeException {
    private final int bridgeSize;
    OutputView outputView = new OutputView();

    public BridgeException(String bridgeSize) {
        this.bridgeSize = validateBridgeSizeRange(validate(bridgeSize));
    }

    public int validate(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch(NumberFormatException e) {
            outputView.printError(ErrorMessage.Bridge_Size.getMessage());
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(bridgeSize);
    }

    public int validateBridgeSizeRange(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20) {
            outputView.printError(ErrorMessage.Bridge_Size.getMessage());

            throw new IllegalArgumentException();
        }

        return bridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
