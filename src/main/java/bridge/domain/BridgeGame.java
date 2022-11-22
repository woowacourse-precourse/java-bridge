package bridge.domain;

import bridge.utils.MapType;
import java.util.List;
import java.util.Stack;

public class BridgeGame {
    public static final String RETRY = "R";
    public static final String QUIT = "Q";
    public static final String CNT_BRIDGE_ERROR = "[ERROR] 다리 길이 또는 cnt 숫자가 잘못 되었습니다";
    public static final String VALUE_ERROR = "[ERROR] 다리 길이 또는 cnt 숫자가 잘못 되었습니다";
    private final BridgeMap bridgeMap;
    private final List<String> bridge;
    private int currentLocation = -1;
    private int cnt;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        bridgeMap = new BridgeMap();
    }

    public List<Stack> move(String movingValue, boolean moveResult) {
        MapType mapType = findMapType(movingValue, moveResult);
        return makeMap(mapType);
    }

    public boolean isFinishWithAllCollect() {
        if (cnt == bridge.size()) {
            return true;
        }
        if (cnt != bridge.size()) {
            return false;
        }
        throw new IllegalStateException(CNT_BRIDGE_ERROR);
    }

    private List<Stack> makeMap(MapType mapType) {
        List<Stack> stairs;
        bridgeMap.make(mapType);
        stairs = bridgeMap.makeListToSend();
        return stairs;
    }

    private MapType findMapType(String movingValue, boolean moveResult) {
        MapType[] mapTypes = MapType.values();
        for (MapType mapType : mapTypes) {
            if (movingValue.equals(mapType.getStairs()) && moveResult == mapType.isPass()) {
                return mapType;
            }
        }
        throw new IllegalArgumentException(VALUE_ERROR);
    }

    public boolean isCorrect(String movingValue) {
        currentLocation++;
        cnt++;
        if (bridge.get(currentLocation).equals(movingValue)) {
            return true;
        }
        if (!bridge.get(currentLocation).equals(movingValue)) {
            return false;
        }
        throw new IllegalArgumentException(VALUE_ERROR);
    }

    public boolean retry(String tryCommand) {
        if (tryCommand.equals(RETRY)) {
            bridgeMap.init();
            currentLocation = -1;
            cnt = 0;
            return true;
        }
        if (tryCommand.equals(QUIT)) {
            return false;
        }
        throw new IllegalStateException(VALUE_ERROR);
    }
}
