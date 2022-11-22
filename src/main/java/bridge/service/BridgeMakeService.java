package bridge.service;

import bridge.type.DirectionType;
import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMakeService {

    public static List<String> getBridgeInfoList(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        List<String> bridge = new ArrayList<>();
        for (int idx = 0; idx < size; idx++) {
            bridge.add(getCrossable(bridgeNumberGenerator));
        }
        return bridge;
    }


    public static String getCrossable(BridgeNumberGenerator bridgeNumberGenerator) {
        if (bridgeNumberGenerator.generate() == 0) {
            return DirectionType.DOWN;
        }
        return DirectionType.UP;
    }

}
