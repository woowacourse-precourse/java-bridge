package bridge.domain.service;

import bridge.domain.resources.Move;

import bridge.domain.resources.bridge.Bridge;

import bridge.domain.resources.converter.ConvertBridgeMap;
import java.util.ArrayList;
import java.util.List;


public class BridgeStateService {

    private final List<String> bridgeMap;
    private int inputCount;
    private boolean flag;

    public BridgeStateService() {
        this.bridgeMap = new ArrayList<>();
        this.inputCount = 0;
        flag = true;
    }

    public void clearBridgeMap() {
        bridgeMap.clear();
        inputCount = 0;
        flag = true;
    }

    public void compare(final Move move, final Bridge bridge) {
        String upOrDown = move.getMove();
        bridgeMap.add(upOrDown);
        if (bridge.isStepOk(upOrDown, inputCount - 1)) {
            flag = true;
        } else if (!bridge.isStepOk(upOrDown, inputCount - 1)) {
            flag = false;
        }
    }

    @Override
    public String toString() {
        return new ConvertBridgeMap(bridgeMap, inputCount, flag).toString();
    }

    public int getInputCount() {
        return inputCount;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setCountUp() {
        ++inputCount;
    }
}
