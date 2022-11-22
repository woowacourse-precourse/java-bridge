package bridge.views;

import bridge.utils.constants.BridgeRoute;
import bridge.utils.constants.BridgeShape;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void printMap(HashMap<String, List<String>> mapInfo) {
        StringBuilder map = new StringBuilder();
        bridgeLineToString(map, mapInfo.get(BridgeRoute.UP.getRoute()));
        bridgeLineToString(map, mapInfo.get(BridgeRoute.DOWN.getRoute()));
        System.out.println(map);
    }

    private void bridgeLineToString(StringBuilder map, List<String> bridgeLine){
        map.append(BridgeShape.START_BRIDGE);
        map.append(String.join(BridgeShape.BOUNDARY_BRIDGE, bridgeLine));
        map.append(BridgeShape.END_BRIDGE+"\n");
    }

    public void printResult() {

    }

}
