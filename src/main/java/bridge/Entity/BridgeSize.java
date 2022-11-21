package bridge.Entity;

import bridge.View.InputValidate;
import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.View.ValidateSet;

public class BridgeSize {

    private final String size;
    private final ValidateSet validateSet = new ValidateSet();

    public BridgeSize(String size) {
        validateSet.Bridge(size);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

}
