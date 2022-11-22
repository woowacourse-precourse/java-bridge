package bridge;

import bridge.utils.Converter;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> bridgeValues = generateBridgeValues(size);

        return Converter.getSituationThrough(bridgeValues);
    }

    private List<Integer> generateBridgeValues(int size) {
        List<Integer> bridgeValues = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridgeValues.add(getBridgeValue());
        }
        return bridgeValues;
    }

    private int getBridgeValue() {
        return bridgeNumberGenerator.generate();
    }
}
