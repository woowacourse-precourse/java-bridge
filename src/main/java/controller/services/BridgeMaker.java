package controller.services;

import constants.DirectionTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeMap = new ArrayList<>();
        List<DirectionTable> directionTable = Arrays.asList(DirectionTable.values());

        for (; bridgeMap.size() < size; ) {
            bridgeMap.add(directionTable.get(bridgeNumberGenerator.generate()).getInitial());
        }
        return bridgeMap;
    }
}
