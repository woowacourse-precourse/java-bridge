package service;

import constant.BothSideConstant;
import constant.InputConstant;
import generator.BridgeNumberGenerator;
import constant.NumberConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {
    private static final int UP_SIDE_INDEX = BothSideConstant.UP_SIDE_INDEX.getConstant();
    private static final int DOWN_SIDE_INDEX = BothSideConstant.DOWN_SIDE_INDEX.getConstant();
    private static final String UP_SIDE = InputConstant.UP_SIDE.getConstant();
    private static final String DOWN_SIDE = InputConstant.DOWN_SIDE.getConstant();

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

    private boolean isBridgeNumberUpSide(int bridgeNumber) {
        return bridgeNumber == UP_SIDE_INDEX;
    }

    private boolean isBridgeNumberDownSide(int bridgeNumber) {
        return bridgeNumber == DOWN_SIDE_INDEX;
    }

    private void addBridgeUpPath(List<String> bridge) {
        bridge.add(UP_SIDE);
    }

    private void addBridgeDownPath(List<String> bridge) {
        bridge.add(DOWN_SIDE);
    }

}