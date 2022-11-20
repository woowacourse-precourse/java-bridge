package bridge.domain;

import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgePrinting {

    private List<Boolean> upState;
    private List<Boolean> downState;
    private static List<Integer> upDownLocation = new ArrayList<>();
    private OutputView outputView = new OutputView();
    private int nowIndex;
    private static boolean stop = false;


    public BridgePrinting(List<Boolean> upState, List<Boolean> downState, int nowIndex) {
        this.upState = upState;
        this.downState = downState;
        this.nowIndex = nowIndex;
    }

    public static boolean isMoveStop() {
        return stop;
    }

    public static void clearUpDownLocation() {
        upDownLocation.clear();
    }

    public static void initRestart() {
        stop = false;
    }

    public void makeList() {
        upDownLocation.add(nowIndex);
        makeUpUserBridge();
        makeDownUserBridge();
        System.out.println();
    }


    private void makeUpUserBridge() {
        String upStateBridge = "[ ";
        final int UP = 1;
        upStateBridge = upStateBridge + addBridge(upState, UP);
        upStateBridge = upStateBridge + "]";
        outputView.printMap(upStateBridge);
    }

    private void makeDownUserBridge() {
        String downStateBridge = "[ ";
        final int DOWN = 0;
        downStateBridge = downStateBridge + addBridge(downState, DOWN);
        downStateBridge = downStateBridge + "]";
        outputView.printMap(downStateBridge);
    }

    private String addBridge(List<Boolean> bridgeState, int upDown) {
        String stateBridge = "";
        for (int index = 0; index < bridgeState.size(); index++) {
            stateBridge = stateBridge + getState(bridgeState, index, upDown);
            if (isIndexBetweenSpace(index, bridgeState.size()-1)) {
                continue;
            }
            stateBridge = stateBridge + "| ";
        }
        return stateBridge;
    }

    private boolean isIndexBetweenSpace(int index, int bridgeStateSize) {
        return index == bridgeStateSize;
    }

    private String getState(List<Boolean> bridgeState, int now, int upDown) {
        if (isRightStep(bridgeState, now, upDown)) {
            return "O ";
        }
        if (isWrongStep(bridgeState, now, upDown)) {
            stop = true;
            return "X ";
        }
        return "  ";
    }

    private boolean isWrongStep(List<Boolean> bridgeState, int now, int upDown) {
        return !bridgeState.get(now) && upDownLocation.get(now)
            == upDown;
    }

    private boolean isRightStep(List<Boolean> bridgeState, int now, int upDown) {
        return bridgeState.get(now) && upDownLocation.get(now) == upDown;
    }


}
