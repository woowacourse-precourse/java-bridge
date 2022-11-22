package bridge.domain;

import bridge.BridgeMaker;
import bridge.util.MoveResult;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    final private List<String> userPath;
    private List<String> bridge;
    private int tryCount;

    public Bridge() {
        userPath = new ArrayList<>();
        tryCount = 1;
    }

    public void makeBridge(int bridgeSize, BridgeMaker bridgeMaker) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public MoveResult move(String movePath) {
        userPath.add(movePath);
        if (isLastMoveSuccess() && isGameSuccess()) {
            return MoveResult.PASSED_BRIDGE;
        }
        if (isLastMoveSuccess()) {
            return MoveResult.MOVE_SUCCESS;
        }
        return MoveResult.MOVE_FAIL;
    }

    public void initBridge() {
        userPath.clear();
        tryCount++;
    }

    public List<List<String>> getMap() {
        List<List<String>> map = new BridgeMapMaker(userPath, bridge).makeMap();
        return map;
    }

    public boolean isGameSuccess() {
        return bridge.size() == userPath.size();
    }

    public int getTryCount() {
        return tryCount;
    }

    private boolean isLastMoveSuccess() {
        int lastIndex = userPath.size() - 1;
        return bridge.get(lastIndex).equals(userPath.get(lastIndex));
    }
}
