package bridge.domain;

import bridge.BridgeMaker;
import bridge.utils.Validator;
import java.util.List;

public class Bridge {
    private int size;
    private List<String> bridgeStatus;

    public Bridge(int size, BridgeMaker bridgeMaker) {
        Validator.checkLengthInput(size);
        this.size = size;
        this.bridgeStatus = bridgeMaker.makeBridge(size);
    }

    public boolean compareByIndex(int index, String value) {
        return this.bridgeStatus.get(index).equals(value);
    }
}
