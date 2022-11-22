package bridge.domain;

import bridge.constant.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeDestination {

    private static final Boolean GAME_OVER = false;
    private static final Boolean RESTART = true;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public boolean isReachFinal(int bridgeSize, int gameCount, BridgePrinting bridgePrinting) {
        if (!BridgePrinting.isMoveStop()) {
            setQuit(bridgeSize, gameCount, bridgePrinting);
            return true;
        }
        return false;
    }

    public void setQuit(int bridgeSize, int gameCount, BridgePrinting bridgePrinting) {
        int nowUserBridgeSize = bridgePrinting.getSize();
        if (bridgeSize == nowUserBridgeSize && !BridgePrinting.isMoveStop()) {
            outputView.printResult(gameCount, true, bridgePrinting);
            return;
        }
        outputView.printResult(gameCount, false, bridgePrinting);
    }


    public boolean judgeRestartOrOver() {
        String destination = inputView.readGameCommand();
        if (destination.equals(GameState.QUIT)) {
            return GAME_OVER;
        }
        return RESTART;
    }

}
