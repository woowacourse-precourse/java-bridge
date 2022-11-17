package bridge.domain;

import static bridge.utils.Util.getInt;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.validator.BridgeValidator;
import java.util.List;

public class Bridge {

    private final String size;
    private List<String> bridge;

    public Bridge(String size) {
        new BridgeValidator(size);
        this.size = size;
        makeBridgeBySize(getInt(size));
    }

    private void makeBridgeBySize(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

}
