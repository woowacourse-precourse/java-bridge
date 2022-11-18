package controller.services;

import bridge.constants.DirectionTable;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeMap = new ArrayList<>();
        String[] positionTable = new String[]{
                DirectionTable.DOWN.getInitial(), DirectionTable.UP.getInitial()
        };

        for(int loop=0; loop < size; loop++){
            bridgeMap.add(positionTable[bridgeNumberGenerator.generate()]);
        }
        return bridgeMap;
    }
}
