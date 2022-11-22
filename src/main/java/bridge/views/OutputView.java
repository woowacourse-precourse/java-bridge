package bridge.views;

import bridge.utils.constants.BridgeGameResult;
import bridge.utils.constants.BridgeRoute;
import bridge.utils.constants.BridgeShape;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static OutputView instance = new OutputView();
    public static String tempMap;

    public static OutputView getInstance() {
        return instance;
    }

    public void printMap(HashMap<String, List<String>> mapInfo) {
        StringBuilder map = new StringBuilder();
        bridgeLineToString(map, mapInfo.get(BridgeRoute.UP.getRoute()));
        bridgeLineToString(map, mapInfo.get(BridgeRoute.DOWN.getRoute()));
        tempMap = map.toString();
        System.out.println(map);
    }

    private void bridgeLineToString(StringBuilder map, List<String> bridgeLine){
        map.append(BridgeShape.START_BRIDGE);
        map.append(String.join(BridgeShape.BOUNDARY_BRIDGE, bridgeLine));
        map.append(BridgeShape.END_BRIDGE+"\n");
    }

    public void printResult(boolean isGameSuccess, int attemptCount) {
        System.out.println(BridgeGameResult.END_GAME_MESSAGE);
        System.out.println(tempMap);
        System.out.println(BridgeGameResult.GAME_RESULT_MESSAGE + printGameSuccessResult(isGameSuccess));
        System.out.println(BridgeGameResult.TOTAL_ATTEMPT_MESSAGE + attemptCount);
    }

    private String printGameSuccessResult(boolean isGameSuccess){
        if(!isGameSuccess){
            return BridgeGameResult.FAIL;
        }
        return BridgeGameResult.SUCCESS;
    }

}
