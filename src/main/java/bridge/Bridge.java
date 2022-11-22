package bridge;

import java.util.*;

public class Bridge {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_MIDDLE = "| ";
    private static final String BRIDGE_SPACE = "  ";
    private static final String BRIDGE_CROSS = "O ";
    private static final String BRIDGE_NOT_CROSS = "X ";
    private static final String UP = "U";
    private static final String DOWN = "D";

    private List<String> list;
    private List<String> upBridge;
    private List<String> downBridge;
    private OutputView bridge;

    public Bridge(List<String> list){
        this.list = list;
        upBridge = new ArrayList<>(Arrays.asList(BRIDGE_START));
        downBridge = new ArrayList<>(Arrays.asList(BRIDGE_START));
        bridge = new OutputView();
    }

    public List<String> getList() {
        return list;
    }

    public boolean isToCross(String moving, int count) {
        if(list.get(count).equals(moving)) {
            addMiddleBridge(count);
            addCrossBridge(moving);
            return true;
        }
        addMiddleBridge(count);
        addNotCrossBridge(moving);
        return false;
    }

    public void printBridge() {
        bridge.printMap(upBridge, downBridge);
    }

    public void printResult(boolean isSuccess, int tryNumber) {
        bridge.printResult();
        printBridge();
        bridge.printIsSuccess(isSuccess, tryNumber);
    }

    private void addMiddleBridge(int count) {
        if(count>0) {
            upBridge.add(BRIDGE_MIDDLE);
            downBridge.add(BRIDGE_MIDDLE);
        }
    }

    private void addCrossBridge(String moving) {
        if(moving.equals(UP)) {
            upBridge.add(BRIDGE_CROSS);
            downBridge.add(BRIDGE_SPACE);
            return;
        }
        upBridge.add(BRIDGE_SPACE);
        downBridge.add(BRIDGE_CROSS);
    }

    private void addNotCrossBridge(String moving) {
        if(moving.equals(UP)) {
            upBridge.add(BRIDGE_NOT_CROSS);
            downBridge.add(BRIDGE_SPACE);
            return;
        }
        upBridge.add(BRIDGE_SPACE);
        downBridge.add(BRIDGE_NOT_CROSS);
    }
}
