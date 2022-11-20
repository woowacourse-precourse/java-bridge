package service;

import generator.BridgeNumberGenerator;
import constant.NumberConstant;
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
        int firstIndex = NumberConstant.FIRST_INDEX.getConstant();
        for (int i = firstIndex; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator();
            buildUpPath(bridge, bridgeNumber);
            buildDownPath(bridge, bridgeNumber);
        }
    }

    private int bridgeNumberGenerator() {
        return bridgeNumberGenerator.generate();
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

    public boolean isBridgeNumberUpSide(int bridgeNumber) {
        return bridgeNumber == NumberConstant.UP_SIDE.getConstant();
    }

    public boolean isBridgeNumberDownSide(int bridgeNumber) {
        return bridgeNumber == NumberConstant.DOWN_SIDE.getConstant();
    }

    public void addBridgeUpPath(List<String> bridge) {
        bridge.add(StringConstant.UP_SIDE.getConstant());
    }

    public void addBridgeDownPath(List<String> bridge) {
        bridge.add(StringConstant.DOWN_SIDE.getConstant());
    }
}