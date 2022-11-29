package bridge.domain;

import bridge.constant.GameState;
import bridge.util.Validate;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeMoveProcess {

    private List<String> moving = new ArrayList<>();
    private List<Boolean> upState = new ArrayList<>();
    private List<Boolean> downState = new ArrayList<>();
    private InputView inputView = new InputView();
    private Validate validate = new Validate();
    private int idx = 0;


    public BridgePrinting moveProcess(List<String> bridgeState, int bridgeSize) {
        clearInfo();
        while (idx < bridgeSize && !BridgePrinting.isMoveStop()) {
            moving.add(inputView.readMoving(validate));
            setPrintState(upState, downState, convertNowIndex(bridgeState.get(idx)));
            makeUserBridge(upState, downState, moving.get(idx));
            idx++;
        }
        return resultUserBridge(upState, downState);
    }

    public void clearInfo() {
        moving.clear();
        upState.clear();
        downState.clear();
        idx = 0;
        BridgePrinting.resetAfterOneGame();
        BridgePrinting.clear();
    }


    private void setPrintState(List<Boolean> upState, List<Boolean> downState, int state) {
        if (state == GameState.UP_STATEMENT) {
            upState.add(true);
            downState.add(false);
        }
        if (state == GameState.DOWN_STATEMENT) {
            upState.add(false);
            downState.add(true);
        }
    }

    public BridgePrinting makeUserBridge(List<Boolean> upState, List<Boolean> downState,
                                         String nowIndex) {
        BridgePrinting bridgePrinting = new BridgePrinting(upState, downState);
        bridgePrinting.addTraceLocation(convertNowIndex(nowIndex));
        bridgePrinting.makeBridge();
        return bridgePrinting;
    }

    public BridgePrinting resultUserBridge(List<Boolean> upState, List<Boolean> downState) {
        BridgePrinting bridgePrinting = new BridgePrinting(upState, downState);
        return bridgePrinting;
    }

    private int convertNowIndex(String nowIndex) {
        if (nowIndex.equals(GameState.UP)) {
            return GameState.UP_STATEMENT;
        }
        return GameState.DOWN_STATEMENT;
    }

}
