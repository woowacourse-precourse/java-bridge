package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Enums.View.LOWER_POSITION;
import static bridge.Enums.View.UPPER_POSITION;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();

            if (randomNumber == 1) {
                bridge.add(UPPER_POSITION.toString());
            } else if (randomNumber == 0) {
                bridge.add(LOWER_POSITION.toString());
            }
        }

        return bridge;
    }

}
