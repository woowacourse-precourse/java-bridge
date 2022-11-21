package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0 ; i < size; ++i) {
            int randomNumber = bridgeNumberGenerator.generate();
            String moving = mappingNumber(randomNumber);
            bridge.add(moving);
        }
        return bridge;
    }

    private String mappingNumber(int number) {
        if (number == 0) {
            return "D";
        }
        if (number == 1) {
            return "U";
        }
        throw new IllegalArgumentException("0과 1 이외에는 mapping 할 수 없습니다");
    }

}
