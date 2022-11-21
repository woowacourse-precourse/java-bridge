package service;

import constant.BothSideConstant;
import constant.InputConstant;
import generator.BridgeNumberGenerator;
import constant.NumberConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int FIRST_INDEX = NumberConstant.FIRST_INDEX.getConstant();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        buildBridgePath(size, bridge);
        return Collections.unmodifiableList(bridge);
    }

    private void buildBridgePath(int size, List<String> bridge) {
        for (int index = FIRST_INDEX; index < size; index++) {
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
        return bridgeNumber == BothSideConstant.UP_SIDE_INDEX.getConstant();
    }

    private boolean isBridgeNumberDownSide(int bridgeNumber) {
        return bridgeNumber == BothSideConstant.DOWN_SIDE_INDEX.getConstant();
    }

    private void addBridgeUpPath(List<String> bridge) {
        bridge.add(InputConstant.UP_SIDE.getConstant());
    }

    private void addBridgeDownPath(List<String> bridge) {
        bridge.add(InputConstant.DOWN_SIDE.getConstant());
    }
}