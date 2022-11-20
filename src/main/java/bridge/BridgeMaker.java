package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.enums.DorU.numberConvertName;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeWay = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String upOrDown = numberConvertName(bridgeNumberGenerator.generate());
            bridgeWay.add(upOrDown);
        }
        return bridgeWay;
    }
}
