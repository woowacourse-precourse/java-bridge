package bridge.domain;

import bridge.model.Player;
import bridge.view.OutputView;

public class BridgeResult {
    public void printResult(Player player, boolean winOrLose) {
        OutputView.getOutputView().printResult(player, winOrLose);
    }

    public void printMap() {
        OutputView.getOutputView().printMap();
    }
}
