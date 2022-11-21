package bridge.Entity;

import bridge.View.InputValidate;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeSize {

    private final String size;

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public BridgeSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

}
