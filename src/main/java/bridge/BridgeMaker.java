package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.Constant.*;

public class BridgeMaker {

    private final List<String> bridgeShape;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.bridgeShape = new ArrayList<>();
    }

    public List<String> makeBridge(int size) {
        for(int i = 0; i < size; i++){
            bridgeShape.add(getRandomShape());
        }
        return bridgeShape;
    }

    private String getRandomShape() {
        if(bridgeNumberGenerator.generate() == 1)
            return MOVE_TO_UPPER;
        return MOVE_TO_LOWER;
    }
}
