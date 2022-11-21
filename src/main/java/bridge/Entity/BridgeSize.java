package bridge.Entity;

import bridge.View.InputValidate;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeSize {

    private final String size;

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public BridgeSize(String size) {
        isValidate(String.valueOf(size));
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public static void isValidate(String size) {
        InputValidate inputValidate = new InputValidate();
        inputValidate.IsCorrectFormatBridgeSize(size);
        inputValidate.IsNoneInputBridgeSize(size);
        inputValidate.IsOverRangeBridgeSize(size);
    }
}
