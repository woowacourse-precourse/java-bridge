package bridge.views;

import bridge.utils.constants.BridgeRoute;
import bridge.utils.constants.BridgeShape;

import bridge.utils.constants.OutputMessage;
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
        map.append(BridgeShape.START_BRIDGE.getShape());
        map.append(String.join(BridgeShape.BOUNDARY_BRIDGE.getShape(), bridgeLine));
        map.append(BridgeShape.END_BRIDGE.getShape());
        map.append("\n");
    }

    public void printResult(boolean isGameSuccess, int attemptCount) {
        System.out.println(OutputMessage.END_GAME_MESSAGE.getMessage());
        System.out.println(tempMap);
        System.out.println(OutputMessage.GAME_RESULT_MESSAGE.getMessage() + getGameSuccessResult(isGameSuccess));
        System.out.println(OutputMessage.TOTAL_ATTEMPT_MESSAGE.getMessage() + attemptCount);
    }

    private String getGameSuccessResult(boolean isGameSuccess){
        if(!isGameSuccess){
            return OutputMessage.FAIL.getMessage();
        }
        return OutputMessage.SUCCESS.getMessage();
    }

}
