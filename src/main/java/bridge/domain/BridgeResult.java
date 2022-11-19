package bridge.domain;

import bridge.model.Player;
import bridge.view.OutputView;

public class BridgeResult {
    public void printResult(Player player, boolean win) {
        OutputView.getOutputView().printResult(player, win);
    }

    public void printMap() {
        OutputView.getOutputView().printMap();
    }
}
