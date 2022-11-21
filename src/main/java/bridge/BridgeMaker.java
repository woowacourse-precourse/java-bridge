package bridge;

import bridge.domain.Movement;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomDigit = bridgeNumberGenerator.generate();
            bridge.add(ConvertDigitToString(randomDigit));
        }
        return bridge;
    }

    private String ConvertDigitToString(int randomDigit) {
        if (Movement.UP.getRandomDigit() == randomDigit) {
            return Movement.UP.getDirection();
        }
        return Movement.DOWN.getDirection() ;
    }
}
