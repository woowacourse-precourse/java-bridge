package bridge.domain;

import bridge.constant.GameState;
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
    private GameState statement = new GameState();


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
        String upStateBridge = statement.startBridge;
        upStateBridge = upStateBridge + addBridge(upState, statement.UP_STATEMENT);
        upStateBridge = upStateBridge + statement.endBridge;
        outputView.printMap(upStateBridge);
    }

    private void makeDownUserBridge() {
        String downStateBridge = statement.startBridge;
        downStateBridge = downStateBridge + addBridge(downState, statement.DOWN_STATEMENT);
        downStateBridge = downStateBridge + statement.endBridge;
        outputView.printMap(downStateBridge);
    }

    private String addBridge(List<Boolean> bridgeState, int upDown) {
        String setBridge = "";
        for (int index = 0; index < bridgeState.size(); index++) {
            setBridge = setBridge + getState(bridgeState, index, upDown);
            if (isIndexBetweenSpace(index, bridgeState.size()-1)) {
                continue;
            }
            setBridge = setBridge + statement.betweenBridge;
        }
        return setBridge;
    }

    private boolean isIndexBetweenSpace(int index, int bridgeStateSize) {
        return index == bridgeStateSize;
    }

    private String getState(List<Boolean> bridgeState, int now, int upDown) {
        if (isRightStep(bridgeState, now, upDown)) {
            return statement.EXIST_SQUARE;
        }
        if (isWrongStep(bridgeState, now, upDown)) {
            stop = true;
            return statement.NO_EXIST_SQUARE;
        }
        return statement.SIDE_SQUARE;
    }

    private boolean isWrongStep(List<Boolean> bridgeState, int now, int upDown) {
        return !bridgeState.get(now) && upDownLocation.get(now)
            == upDown;
    }

    private boolean isRightStep(List<Boolean> bridgeState, int now, int upDown) {
        return bridgeState.get(now) && upDownLocation.get(now) == upDown;
    }


}
