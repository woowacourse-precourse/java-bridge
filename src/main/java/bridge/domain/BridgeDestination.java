package bridge.domain;

import bridge.constant.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeDestination {


    private OutputView outputView = new OutputView();

    private InputView inputView = new InputView();
    private final Boolean GAME_OVER = false;
    private final Boolean RESTART = true;

    public boolean isReachFinal(int bridgeSize, int gameCount, BridgePrinting bridgePrinting) {
        if (!BridgePrinting.isMoveStop()) {
            setQuit(bridgeSize, gameCount, bridgePrinting);
            return true;
        }
        return false;
    }

    public void setQuit(int bridgeSize,  int gameCount, BridgePrinting bridgePrinting) {
        int nowUserBridgeSize=bridgePrinting.getSize();
        if (bridgeSize == nowUserBridgeSize && !BridgePrinting.isMoveStop()) {
            outputView.printResult(gameCount,  bridgePrinting,true);
            return;
        }
        outputView.printResult(gameCount, bridgePrinting, false);
    }


    public boolean judgeRestartOrOver() {
        String destination = inputView.readGameCommand();
        if (destination.equals(GameState.QUIT)) {
            return GAME_OVER;
        }
        return RESTART;
    }

}
