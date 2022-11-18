package service;

import generator.BridgeNumberGenerator;
import constant.GameConstant;
import constant.StringConstant;
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

        buildBridgePath(size, bridge);
        return Collections.unmodifiableList(bridge);
    }

    private void buildBridgePath(int size, List<String> bridge) {
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator();
            buildUpPath(bridge, bridgeNumber);
            buildDownPath(bridge, bridgeNumber);
        }
    }

    private void buildUpPath(List<String> bridge, int bridgeNumber) {
        if (isBridgeNumberUpSide(bridgeNumber)) {
            addBridgeUpPath(bridge);
        }
    }

    private void buildDownPath(List<String> bridge, int bridgeNumber) {
        if (isBridgeNumberDownSide(bridgeNumber)) {
            addBridgeDownPath(bridge);
        }
    }

    private int bridgeNumberGenerator() {
        return bridgeNumberGenerator.generate();
    }

    public boolean isBridgeNumberUpSide(int bridgeNumber) {
        return bridgeNumber == GameConstant.UP_SIDE.getConstant();
    }

    public boolean isBridgeNumberDownSide(int bridgeNumber) {
        return bridgeNumber == GameConstant.DOWN_SIDE.getConstant();
    }

    public void addBridgeUpPath(List<String> bridge) {
        bridge.add(StringConstant.UP_SIDE.getConstant());
    }

    public void addBridgeDownPath(List<String> bridge) {
        bridge.add(StringConstant.DOWN_SIDE.getConstant());
    }

}