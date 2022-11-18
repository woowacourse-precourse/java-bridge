package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return null;
    }

    public void addBridgeMoving(List<String> bridge, int number) {
        try {
            MovingType moving = MovingType.selectMovingType(number);
            bridge.add(moving.getInitial());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}