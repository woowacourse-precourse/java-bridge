package bridge.domain;

import bridge.constant.GameState;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgePrinting {

    private List<Boolean> upState;
    private List<Boolean> downState;
    private static List<Integer> traceLocation = new ArrayList<>();
    private OutputView outputView = new OutputView();
    private int nowLocation;
    private static boolean stop = false;
    
    public BridgePrinting(List<Boolean> upState, List<Boolean> downState, int nowLocation) {
        this.upState = upState;
        this.downState = downState;
        this.nowLocation = nowLocation;
    }

    public static boolean isMoveStop() {
        return stop;
    }

    public static void clearUpDownLocation() {
        traceLocation.clear();
    }

    public static void initRestart() {
        stop = false;
    }

    public void makeList() {
        traceLocation.add(nowLocation);
        makeUpUserBridge();
        makeDownUserBridge();
        System.out.println();
    }

    private void makeUpUserBridge() {
        String upStateBridge = GameState.startBridge;
        upStateBridge = upStateBridge + addBridge(upState, GameState.UP_STATEMENT);
        upStateBridge = upStateBridge + GameState.endBridge;
        outputView.printMap(upStateBridge);
    }

    public void makeDownUserBridge() {
        String downStateBridge = GameState.startBridge;
        downStateBridge = downStateBridge + addBridge(downState, GameState.DOWN_STATEMENT);
        downStateBridge = downStateBridge + GameState.endBridge;
        outputView.printMap(downStateBridge);
    }

    public String addBridge(List<Boolean> bridgeState, int upDown) {
        String setBridge = "";
        for (int index = 0; index < bridgeState.size(); index++) {
            setBridge = setBridge + getState(bridgeState, index, upDown);
            if (isIndexBetweenSpace(index, bridgeState.size()-1)) {
                continue;
            }
            setBridge = setBridge + GameState.betweenBridge;
        }
        return setBridge;
    }

    public boolean isIndexBetweenSpace(int index, int bridgeStateSize) {
        return index == bridgeStateSize;
    }

    public String getState(List<Boolean> bridgeState, int nowIndex, int nowState) {
        if (isRightStep(bridgeState, nowIndex, nowState)) {
            return GameState.EXIST_SQUARE;
        }
        if (isWrongStep(bridgeState, nowIndex, nowState)) {
            stop = true;
            return GameState.NO_EXIST_SQUARE;
        }
        return GameState.SIDE_SQUARE;
    }

    public boolean isWrongStep(List<Boolean> bridgeState, int now, int nowState) {
        return !bridgeState.get(now) && traceLocation.get(now)
            == nowState;
    }

    public boolean isRightStep(List<Boolean> bridgeState, int now, int nowState) {
        return bridgeState.get(now) && traceLocation.get(now) == nowState;
    }


}
