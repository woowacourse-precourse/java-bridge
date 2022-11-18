package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> states;

    public Bridge(List<String> states) {
        this.states = states;
    }

    public boolean checkSuccess(Bridge bridge) {
        int size = getSize();

        if (size != bridge.getSize()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            String userState = bridge.getState(i);
            boolean isEqual = compareState(i, userState);

            if (!isEqual) {
                return false;
            }
        }
        return true;
    }

    private boolean compareState(int index, String state) {
        String rightState = getState(index);
        if (rightState.equals(state)) {
            return true;
        }
        return false;
    }

    public String getMap(Bridge bridge) {
        String map = getUpMap(bridge);
        map += GameMessage.LINE_BREAK;
        map += getDownMap(bridge);
        map += GameMessage.LINE_BREAK;
        return map;
    }

    private String getUpMap(Bridge bridge) {
        List<String> upBridge = BridgeValue.getLeftSide();
        upBridge = getUpStates(bridge, upBridge);

        return upBridge.toString();
    }

    private String getDownMap(Bridge bridge) {
        List<String> downBridge = BridgeValue.getLeftSide();
        downBridge = getDownStates(bridge, downBridge);

        return downBridge.toString();
    }

    private List<String> getUpStates(Bridge bridge, List<String> upBridge) {
        int size = bridge.getSize();
        for (int i = 0; i < size; i++) {
            String rightState = states.get(i);
            String userState = bridge.getState(i);
            String state = BridgeValue.getUpState(rightState, userState);
            String divisionOrBracket = BridgeValue.getDivisionOrBracket(size-1, i);
            upBridge.add(state);
            upBridge.add(divisionOrBracket);
        }

        return upBridge;
    }


    private List<String> getDownStates(Bridge bridge, List<String> downBridge) {
        int size = bridge.getSize();
        for (int i = 0; i < size; i++) {
            String rightState = states.get(i);
            String userState = bridge.getState(i);
            String state = BridgeValue.getDownState(rightState, userState);
            String divisionOrBracket = BridgeValue.getDivisionOrBracket(size-1, i);
            downBridge.add(state);
            downBridge.add(divisionOrBracket);
        }

        return downBridge;
    }

    public void addState(String state) {
        states.add(state);
    }

    public void removeState() {
        int lastIndex = getSize() - 1;
        states.remove(lastIndex);
    }

    private String getState(int index) {
        return states.get(index);
    }

    private String getLastState() {
        int lastIndex = getSize() - 1;
        return states.get(lastIndex);
    }

    private int getSize() {
        return states.size();
    }
}
