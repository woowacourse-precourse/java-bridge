package bridge.domain;

import bridge.constant.GameState;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgePrinting {

    private static List<Boolean> upState;
    private static List<Boolean> downState;

    private static List<Integer> traceLocation = new ArrayList<>();
    private static boolean stop = false;
    private OutputView outputView = new OutputView();

    public BridgePrinting(List<Boolean> upState, List<Boolean> downState) {
        this.upState = upState;
        this.downState = downState;
    }

    public static boolean isMoveStop() {
        return stop;
    }

    public static void clearUpDownLocation() {
        traceLocation.clear();
    }

    public static void resetAfterOneGame() {
        stop = false;
    }


    public void addTraceLocation(int nowLocation) {
        traceLocation.add(nowLocation);
    }

    public void makeBridge() {
        makeUpUserBridge();
        makeDownUserBridge();
        System.out.println();
    }

    public void makeUpUserBridge() {
        String upStateBridge = "";
        upStateBridge = upStateBridge + addBridge(upState, GameState.UP_STATEMENT);
        outputView.printMap(upStateBridge);
    }

    public void makeDownUserBridge() {
        String downStateBridge = "";
        downStateBridge = downStateBridge + addBridge(downState, GameState.DOWN_STATEMENT);
        outputView.printMap(downStateBridge);
    }

    public String addBridge(List<Boolean> bridgeState, int upDown) {
        String setBridge = "";
        for (int index = 0; index < bridgeState.size(); index++) {
            setBridge = setBridge + getState(bridgeState, index, upDown);
        }
        setBridge = setBridge.chars().boxed().map(Character::toString)
            .collect(Collectors.joining(" | ", "[ ", " ]")); // 새롭게 수정한 부분 Collectors.joining 활용하여 리팩토링


        return setBridge;
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

    public int getSize() {
        return upState.size();
    }


}
