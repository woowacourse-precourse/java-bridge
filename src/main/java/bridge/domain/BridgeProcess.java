package bridge.domain;

import bridge.constant.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeProcess {

    private static List<String> moving = new ArrayList<>();
    private List<Boolean> upState = new ArrayList<>();
    private List<Boolean> downState = new ArrayList<>();
    private InputView inputView = new InputView();
    int idx=0;


    public int moveProcess(List<String> bridgeState, int bridgeSize){
        clearInfo();
        while (idx < bridgeSize && !BridgePrinting.isMoveStop()) {
            System.out.println("bridgeState = " + bridgeState); // 출력시 어디가 갈 수 있는 칸인지 확인하기 위한 역할
            moving.add(inputView.readMoving());
            setPrintState(upState, downState, convertNowIndex(bridgeState.get(idx)));
            makeUserBridge(upState, downState, moving.get(idx));
            idx++;
        }
        return idx;
    }

    public void clearInfo() {
        moving.clear();
        upState.clear();
        downState.clear();
        idx = 0;
        BridgePrinting.clearUpDownLocation();
    }


    private void setPrintState(List<Boolean> upState, List<Boolean> downState, int upDown) {
        if (upDown == GameState.UP_STATEMENT) {
            upState.add(true);
            downState.add(false);
        }
        if (upDown == GameState.DOWN_STATEMENT) {
            upState.add(false);
            downState.add(true);
        }
    }

    private void makeUserBridge(List<Boolean> upState  , List<Boolean> downState,
        String nowIndex) {
        BridgePrinting bridgePrinting = new BridgePrinting(upState, downState, convertNowIndex(nowIndex));
        bridgePrinting.makeList();
    }

    private int convertNowIndex(String nowIndex) {
        if (nowIndex.equals(GameState.UP)) {
            return GameState.UP_STATEMENT;
        }
        return GameState.DOWN_STATEMENT;
    }

    public static List<String> getMoving() {
        return moving;
    }
}
