package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 3에서 20사이의 수가 아닙니다.");
        }
    }

    private String convert(int random) {
        if (random == 0) {
            return "D";
        } else {
            return "U";
        }
    }

    public List<String> makeBridge(int size) {
        validate(size);

        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++){
            bridge.add(convert(bridgeNumberGenerator.generate()));
        }

        return bridge;
    }
}
