package bridge;

import bridge.domain.Direction;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> crossByBridge = new ArrayList<>();
        for (int bridgePoint = 0; bridgePoint < size; bridgePoint++) {
            int randomNumber = bridgeNumberGenerator.generate();
            new BridgeRandomNumber(randomNumber);
            crossByBridge.add(convertRandomToDirection(randomNumber));
        }
        return crossByBridge;
    }

    private String convertRandomToDirection(int randomNumber) {
        return Direction.findDirectionByNumber(randomNumber).getMovingDirection();
    }
}
