package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.enums.MovingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            addBridgeMoving(bridge, randomNumber);
        }
        return Collections.unmodifiableList(bridge);
    }

    public void addBridgeMoving(List<String> bridge, int number) {
        try {
            MovingType moving = MovingType.selectMovingTypeByCode(number);
            bridge.add(moving.getInitial());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}