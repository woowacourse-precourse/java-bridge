package bridge.domain;

import bridge.constant.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeDestination {


    private List<Boolean> upState = new ArrayList<>();
    private List<Boolean> downState = new ArrayList<>();

    private BridgeMoveProcess bridgeMoveProcess = new BridgeMoveProcess();
    private OutputView outputView = new OutputView();

    private InputView inputView = new InputView();
    private final Boolean GAME_OVER = false;
    private final Boolean RESTART = true;

    public boolean isReachFinal(int bridgeSize,int idx, int gameCount) {
        if (!BridgePrinting.isMoveStop()) {
            setQuit(bridgeSize, idx,gameCount);
            return true;
        }
        return false;
    }

    public void setQuit(int bridgeSize, int idx, int gameCount) {
        final int final_idx=idx-1;
        int nowIndex = convertNowIndex(bridgeMoveProcess.getMoving().get(final_idx));
        BridgePrinting resultBridgePrinting = new BridgePrinting(upState, downState, nowIndex);
        if (bridgeSize == idx && !BridgePrinting.isMoveStop()) {
            outputView.printResult(gameCount, resultBridgePrinting, true);
            return;
        }
        outputView.printResult(gameCount, resultBridgePrinting, false);
    }

    private int convertNowIndex(String nowIndex) {
        if (nowIndex.equals(GameState.UP)) {
            return GameState.UP_STATEMENT;
        }
        return GameState.DOWN_STATEMENT;
    }


    public boolean judgeRestartOrOver() {
        String destination = inputView.readGameCommand();
        if (destination.equals(GameState.QUIT)) {
            return GAME_OVER;
        }
        return RESTART;
    }

}
